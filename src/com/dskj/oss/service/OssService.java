package com.dskj.oss.service;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.dskj.base.Base;
import com.dskj.oss.entity.OssConfig;
import com.dskj.oss.mapper.OssMapper;
import com.dskj.util.HMACSHA1;
import com.dskj.util.ImageUtil;
import com.dskj.util.StringUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OssService extends Base implements InitializingBean,
        DisposableBean {
    @Autowired
    private OssMapper ossMapper;

    private Map<String, String> ossConfigs = new HashMap<String, String>();

    private OSSClient ossClient = null;

    public void destroy() throws Exception {
        if (ossClient != null)
            ossClient.shutdown();
    }

    public void afterPropertiesSet() throws Exception {
        List<OssConfig> list = ossMapper.getOssConfig();
        if (list == null)
            throw new Exception("ossConfig config init fail.");
        for (OssConfig config : list) {
            ossConfigs.put(config.getKey(), config.getValue());
        }
        ClientConfiguration conf = new ClientConfiguration();
        ossClient = new OSSClient(ossConfigs.get("aliyun_oss_endpoint"),
                ossConfigs.get("aliyun_oss_access_key"),
                ossConfigs.get("aliyun_oss_access_key_secret"), conf);
    }

    public String signContent(String content) throws Exception {
        return "OSS "
                + ossConfigs.get("aliyun_oss_access_key")
                + ":"
                + Base64.encodeBase64String(HMACSHA1
                .getSignature(
                        ossConfigs.get("aliyun_oss_access_key_secret"),
                        content).getBytes());
    }

    public Object getBucketList() throws Exception {
        return ossClient.listBuckets();
    }

    public Object getListObjects() throws Exception {
        return ossClient.listObjects(ossConfigs.get("aliyun_oss_bucket"));
    }

    public Object getObject(String name) throws Exception {
        return ossClient.getObject(new GetObjectRequest(ossConfigs
                .get("aliyun_oss_bucket"), name));
    }

    /**
     * @param parentFileName 如：announcement
     * @param name           如：/usr/local/tomcat/temp/test.png
     * @return
     * @throws Exception
     */
    public String addObject(String parentFileName, String name) throws Exception {
        String fileName = StringUtil.generateUUID32() + "."
                + name.substring(name.lastIndexOf(".") + 1);
        ossClient.putObject(ossConfigs.get("aliyun_oss_bucket"), parentFileName + "/"
                + fileName, new File(name));
        return "http://" + ossConfigs.get("aliyun_oss_bucket") + "."
                + ossConfigs.get("aliyun_oss_endpoint") + "/" + parentFileName + "/"
                + fileName;
    }

    /**
     * 为图片生成小尺寸规格
     * 如：源，http://egg-cloud-huanan.oss-cn-shenzhen.aliyuncs.com/imageRoom/20160923141941723-7862.jpg
     * 改, http://egg-cloud-huanan.oss-cn-shenzhen.aliyuncs.com/imageRoom/20160923141941723-7862-small.jpg
     */
    public void addObjectSmallSpec(String fileName) throws Exception {
        ImageUtil imageUtil = new ImageUtil(fileName);
        String smallSpec = imageUtil.resizeFix(ImageUtil.W, ImageUtil.H);
        File small = new File(smallSpec);
        try {
            ossClient.putObject(ossConfigs.get("aliyun_oss_bucket"), imageUtil.getParentPath() + "/"
                    + smallSpec.substring(smallSpec.lastIndexOf("/") + 1), small);
            logger.info("http://" + ossConfigs.get("aliyun_oss_bucket") + "."
                    + ossConfigs.get("aliyun_oss_endpoint") + "/" + imageUtil.getParentPath() + "/"
                    + smallSpec.substring(smallSpec.lastIndexOf("/") + 1));
        } finally {
            if (small.exists())
                small.delete();
        }
    }

    public static void main(String[] args) {
        String s = "http://egg-cloud-huanan.oss-cn-shenzhen.aliyuncs.com/imageRoom/20160923141941723-7862.jpg";
        System.out.println(s.substring(s.lastIndexOf("/") + 1, s.lastIndexOf(".")));
        System.out.println(s.substring(s.lastIndexOf(".") + 1));
        System.out.println(s.split("/")[s.split("/").length - 2]);
    }

}
