package com.dalaran.test.context;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.dalaran.context.SpringRootConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringRootConfig.class})
@TransactionConfiguration(defaultRollback=false)
public class BaseTest {

}
