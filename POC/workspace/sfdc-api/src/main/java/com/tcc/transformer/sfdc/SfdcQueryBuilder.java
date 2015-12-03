package com.tcc.transformer.sfdc;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SfdcQueryBuilder extends AbstractMessageTransformer {

	private static Logger logger = LoggerFactory.getLogger(SfdcQueryBuilder.class);

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		logger.info("SfdcQueryBuilder: info");
		String queryParams [] = message.getInboundProperty("http.query.params");
		
		return message;
	}
	

}
