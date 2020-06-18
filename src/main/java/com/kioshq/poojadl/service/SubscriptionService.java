package com.kioshq.poojadl.service;

import com.kioshq.poojadl.dto.SubscriptionTemplate;
import com.kioshq.poojadl.entity.Subscription;

public interface SubscriptionService {
	Subscription createNewSubscription(SubscriptionTemplate subscription);
}
