package com.tcc.transformer.sfdc;

import java.util.Set;
import java.util.regex.Pattern;

import org.drools.lang.dsl.DSLMapParser.pattern_return;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.http.internal.ParameterMap;
import org.mule.transformer.AbstractMessageTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SfdcQueryBuilderForAccounts extends AbstractMessageTransformer {

	private static Logger logger = LoggerFactory.getLogger(SfdcQueryBuilderForAccounts.class);

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		logger.info("SfdcQueryBuilder: info");
		
		ParameterMap httpParams = (ParameterMap) message.getInboundProperty("http.query.params");
		
		if (httpParams.size() == 0 ) {
			logger.info("No query parameter. ");
			return "";
		}
		
		Set<String> keySet = httpParams.keySet();
		
		StringBuilder builder = new StringBuilder();
		
		for(String key : keySet) {
			String value = httpParams.get(key);
			String filter = key + " = " + "\'" + value + "\'" + " AND ";
			builder.append(filter);
		}
		
		String overAllFilterString = builder.toString();
		
		overAllFilterString = replaceLast(overAllFilterString, "AND", "");
		
		logger.info("SFDC Query Filter: " + overAllFilterString);
				
		return "WHERE (" + overAllFilterString + ")";

	}
	
	private static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }

}
