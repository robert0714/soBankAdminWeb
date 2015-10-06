package com.iisigroup.product.secure.service;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import com.iisigroup.jtd.ude.common.DataSets;
import com.iisigroup.jtd.ude.common.ServiceTestExecutionListener;
import com.iisigroup.jtd.ude.config.JPAConfig;
import com.iisigroup.product.secure.domain.AccountPo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfig.class })
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class AccountServiceForJPAImplTest   extends AbstractTransactionalJUnit4SpringContextTests {
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	private AccountService service ;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@DataSets(setUpDataSet= "/com/iisigroup/product/secure/service/secureTest.xls")
	@Test
	public void testFindAll() throws Exception {
		List<AccountPo> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
	}
	@DataSets(setUpDataSet= "/com/iisigroup/product/secure/service/secureTest.xls")
	@Test
	public void testFindById() throws Exception {
		List<AccountPo> result = service.findAll();

		AccountPo po = service.findById(result.get(0).getId());
		assertNotNull(po);
	}
	@DataSets(setUpDataSet= "/com/iisigroup/product/secure/service/secureTest.xls")
	@Test
	public void testSave() throws Exception {
		deleteFromTables("ACCOUNT");

		AccountPo po = new AccountPo();
		po.setAccountName("user01");
		po.setActivate(true);
		po.setUserRealName("Test User Name");

        service.save(po);
        em.flush();

        List<AccountPo> pos = service.findAll();
        assertEquals(1, pos.size());
	}
	@DataSets(setUpDataSet= "/com/iisigroup/product/secure/service/secureTest.xls")
	@Test
	public void testFindAllByPage() throws Exception {
		Pageable pageable = new org.springframework.data.domain.PageRequest(0,10) ;		 
		Page<AccountPo> page = service.findAllByPage(pageable);
		final int size = page.getNumberOfElements();
		ArrayList<AccountPo> list = Lists.newArrayList(page.iterator());
		assertNotNull(list);
		assertEquals(1, size);
	}
}
