package dev.ifrs.service;

import dev.ifrs.dto.TransferDto;
import dev.ifrs.model.Transfer;
 
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
 
@Transactional
@ApplicationScoped
public class TransferService {
    @Inject
    EntityManager em;
 
    public List<Transfer> findAll() {
        return em.createQuery("select t from Transfer t", Transfer.class).getResultList();
    }
 
    public Long create(TransferDto transferDto) {
        Transfer transfer = new Transfer();
        transfer.setAccountFrom(transferDto.getAccountFrom());
        transfer.setAccountTo(transferDto.getAccountTo());
        transfer.setAmount(transferDto.getAmount());
        transfer.setTransferDate(new Date());
        em.persist(transfer);
 
        return transfer.getId();
    }
 
}