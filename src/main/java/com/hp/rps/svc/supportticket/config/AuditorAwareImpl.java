package com.hp.rps.svc.supportticket.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

public class AuditorAwareImpl implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor() {
        return Optional.ofNullable(UUID.fromString("d4db0a66-c1f9-4005-99d4-83d79a17fe9f"));
    }

}
