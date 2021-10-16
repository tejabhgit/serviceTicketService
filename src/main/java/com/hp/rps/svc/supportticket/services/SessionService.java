package com.hp.rps.svc.supportticket.services;

import com.example.grpc.server.grpcserver.CreateOneSessionRequest;
import com.hp.rps.svc.supportticket.model.MetaInfo;
import com.hp.rps.svc.supportticket.model.Session;
import com.hp.rps.svc.supportticket.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class SessionService{
    private SessionRepository sessionRepository;

    @Autowired
    public void SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void addSession(CreateOneSessionRequest request) {
        log.info("Creating a Support Session for support ticket resource {}", request.getCreateParams().getSupportTicketId());
        Session session = buildSessionEntity(request);
        insert(session);
        log.info("Successfully added a Support Session resource {}", session.getId().toString());
    }

    private Session buildSessionEntity(CreateOneSessionRequest request) {
        MetaInfo metaInfo = MetaInfo.builder()
                .build();

        Session session = Session.builder()
                .supportTicketId(request.getCreateParams().getSupportTicketId())
                .metaInfo(metaInfo)
                .build();
        return session;
    }

    //DB methods
    public Optional<Session> findByRequest(UUID uuid, String supportTicketId){
        return sessionRepository.findByIdOrSupportTicketId(uuid, supportTicketId);
    }

    public void insert(Session session){
        sessionRepository.save(session);
    }

    public void update(Session session){
        sessionRepository.save(session);
    }

    public void deleteSession(UUID uuid) {
        sessionRepository.deleteById(uuid);
    }

//    public Page<Session> findAllPagedResponse(FindAllSessionsRequest request, Page<Session> pagedResult) {
//        Pageable paging = PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getSortBy()));
//        pagedResult = Objects.nonNull(paging) ? sessionRepository.findAll(paging) : sessionRepository.findAll(Pageable.unpaged());
//        return pagedResult;
//    }

    public List<Session> getAllByExample(Session session){
        Example<Session> example = Example.of(session);
        return sessionRepository.findAll(example);
    }
}
