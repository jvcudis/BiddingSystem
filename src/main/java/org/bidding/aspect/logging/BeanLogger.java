package org.bidding.aspect.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

@Component
public class BeanLogger implements BeanPostProcessor {

	protected Logger logger;
	
	// Set to true to TURN ON logging for bean instantiation
	protected boolean enabled = false;
	
	public BeanLogger() {
		logger = LoggerFactory.getLogger(getClass());
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (!enabled)
			return bean;
		
		if (bean instanceof Ordered) {
			String order = (bean instanceof Ordered) ? String
					.valueOf(((Ordered) bean).getOrder()) : "unknown";
			logger.info(bean.getClass().getName() + " - Order: " + order);
		} else {
			logger.info(bean.getClass().getName());
		}

		if (bean instanceof HandlerExceptionResolverComposite) {
			logger.info("   resolvers: "
					+ ((HandlerExceptionResolverComposite) bean)
							.getExceptionResolvers());
		}

		return bean;
	}
	
}