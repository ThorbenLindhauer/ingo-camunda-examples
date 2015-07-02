package com.camunda.consulting.webservice.businessrules;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.camunda.consulting.webservice.businessrules.model.DiscountRuleEntry;

@Named
@Stateless
public class RuleEntryDAO {

  @PersistenceContext
  private EntityManager entityManager;
  
  @SuppressWarnings("unchecked")
  @Produces
  @Named("ruleList")
  public List<DiscountRuleEntry> findAllDiscountRuleEntries() {
    return entityManager.createQuery("SELECT obj from " + DiscountRuleEntry.class.getSimpleName() + " obj").getResultList();
  }

  public void save(DiscountRuleEntry discountRuleEntry) {
    entityManager.persist(discountRuleEntry);
  }

  public void update(DiscountRuleEntry discountRuleEntry) {
    entityManager.merge(discountRuleEntry);
  }

  public DiscountRuleEntry findDiscountRuleEntry(Long entryId) {
    return entityManager.find(DiscountRuleEntry.class, entryId);
  }
  
}
