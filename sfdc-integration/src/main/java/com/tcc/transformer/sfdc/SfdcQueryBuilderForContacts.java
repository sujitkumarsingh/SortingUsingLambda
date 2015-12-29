package com.tcc.transformer.sfdc;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.http.internal.ParameterMap;
import org.mule.transformer.AbstractMessageTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SfdcQueryBuilderForContacts extends AbstractMessageTransformer {

	private static Logger logger = LoggerFactory.getLogger(SfdcQueryBuilderForContacts.class);

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		logger.info("SfdcQueryBuilder: info");
		ParameterMap httpParams = (ParameterMap) message.getInboundProperty("http.query.params");
		String mobileNumber = httpParams.get("mobileNumber");
		logger.info("Mobile Number=" + mobileNumber);
		
		return "MobilePhone =" + "\'" + mobileNumber + "\'";
	}
	

}
