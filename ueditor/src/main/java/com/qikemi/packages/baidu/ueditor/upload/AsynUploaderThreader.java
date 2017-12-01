package com.qikemi.packages.baidu.ueditor.upload;

import com.aliyun.openservices.oss.OSSClient;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 异步上传文件到阿里云OSS
 * 
 * @author XieXianbin me@xiexianbin.cn
 */
public class AsynUploaderThreader extends Thread {

	private static Logger logger = LoggerFactory.getLogger(AsynUploaderThreader.class);
	private JSONObject stateJson = null;
	private OSSClient client = null;
	private HttpServletRequest request = null;

	public AsynUploaderThreader() {
	}

	public void init(JSONObject stateJson, OSSClient client,
			HttpServletRequest request) {
		this.stateJson = stateJson;
		this.client = client;
		this.request = request;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SynUploader synUploader = new SynUploader();
		synUploader.upload(stateJson, client, request);
		logger.debug("asynchronous upload image to aliyun oss success.");
	}

}
