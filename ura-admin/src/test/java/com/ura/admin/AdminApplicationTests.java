package com.ura.admin;

import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

	@Autowired
	private SysUserService sysUserService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUser() {
		SysUserEntity user = new SysUserEntity();
		user.setUserId(1L);
		user.setUsername("admin");
		user.setLocked(1);
		user.setPassword("123456");

		sysUserService.save(user);
	}

	@Test
	public void getPrincipal() {
//		Object obj = ShiroUtils.getPrincipal();
    Object obj = SecurityUtils.getSubject().getPrincipal();
		SysUserEntity user = (SysUserEntity)obj;
		String userName = user.getUsername();
		System.out.print("========= " + userName);
	}
}
