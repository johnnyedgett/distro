package com.kioshq.distro.service;

import com.kioshq.distro.dto.SubscriptionTemplate;
import com.kioshq.distro.entity.Subscription;

public interface SubscriptionService {
	Subscription createNewSubscription(SubscriptionTemplate subscription);
}
