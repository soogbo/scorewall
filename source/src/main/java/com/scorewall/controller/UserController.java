package com.scorewall.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.scorewall.pojo.User;
import com.scorewall.service.UserServiceImpl;
import com.scorewall.util.DataGridResult;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	/**
	 * 根据ID进行查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> queryUserById(@PathVariable("id") Long id){
		try {
			// 查询数据
			User user = this.userService.queryUserById(id);
			// 判断是否为null
			if(user != null){
				// 如果不为null，返回用户，并且返回200状态码
				return ResponseEntity.ok(user);
			}
			// 如果没找到，返回404
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			// 如果出现异常，我们返回500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 分页查询用户
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<DataGridResult<User>> pageList(
			@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="rows",defaultValue="5")Integer rows ){
		
		DataGridResult<User> result;
		try {
			result = userService.queryUserPageList(page,rows);
			// 判断是否为null
			if(result != null){
				// 如果不为null，返回用户，并且返回200状态码
				return ResponseEntity.ok(result);
			}
			// 如果没找到，返回404
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 如果出现异常，我们返回500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/** 
	 * 保存/修改 用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user/save",method={RequestMethod.POST})
	public ResponseEntity<Void> save(User user){
		try {
				if (user.getId() != null) {
				userService.updateUser(user);
				//修改操作成功，不返回数据，状态码204
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				userService.saveUser(user);	
				//创建成功，不返回数据，状态码201
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//出现异常，返回500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/** 
	 * 根据id批量删除用户
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/user/delete",method=RequestMethod.POST)
	public ResponseEntity<Void> delete(@RequestParam(value="ids",required=true)Long[] ids){
		
		try {
			userService.deleteUserByIds(ids);	
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			//出现异常，返回500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	} 
	
	/**
	 * 导出查询页用户数据为excel或pdf
	 * @param page
	 * @param rows
	 * @param excelOrPdf
	 * @return
	 */
	@RequestMapping(value="/user/export/{excelOrPdf}",method=RequestMethod.GET)
	public ModelAndView exportPdf(
			@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="rows",defaultValue="5")Integer rows,
			@PathVariable("excelOrPdf")String excelOrPdf){
		
		ModelAndView mav = new ModelAndView(excelOrPdf+"View");
		
		DataGridResult<User> result = userService.queryUserPageList(page,rows);
		mav.addObject("users", result.getRows());
		return mav;
	}
	
	
	
	
}
