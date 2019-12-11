package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.module.company.dao.AlbumDao;
import com.junkj.module.company.entity.Album;
import com.junkj.module.file.biz.FileUploadBiz;
import com.junkj.module.file.entity.FileUpload;
import com.junkj.module.file.utils.FileUploadUtils;
import com.junkj.module.member.entity.Growup;

/**
 * 相册biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月19日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class AlbumBiz extends CrudBiz<AlbumDao, Album> {

	@Autowired
	private FileUploadBiz fileUploadBiz;
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<Album> findPage(Album album) {
		Page<Album> page = super.findPage(album);
		FileUpload where = new FileUpload();
		where.setBizType(Album.FILE_TYPE);
		page.getList().forEach(row -> {
			where.setBizId(row.getId());
			row.setFileUpload(fileUploadBiz.findList(where));
		});
		return page;
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<Album> findList(Album album) {
		return super.findList(album);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Album album) {
		super.save(album);
		// 保存上传图片
		String img = FileUploadUtils.saveFileUpload(album.getId(), Album.FILE_TYPE);
		if(StrUtils.notBlank(img)){
			album.setImg(img);
			super.update(album);
		}
	}
	
}
