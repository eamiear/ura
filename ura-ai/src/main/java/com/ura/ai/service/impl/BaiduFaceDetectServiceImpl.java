package com.ura.ai.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ura.ai.dao.BaiduFaceDetectDao;
import com.ura.ai.entity.FaceDetectEntity;
import com.ura.ai.service.BaiduFaceDetectService;
import org.springframework.stereotype.Service;

@Service("baiduFaceDetectService")
public class BaiduFaceDetectServiceImpl extends ServiceImpl<BaiduFaceDetectDao,FaceDetectEntity> implements BaiduFaceDetectService {
  @Override
  public boolean save(FaceDetectEntity faceDetectEntity) {
    return this.insert(faceDetectEntity);
  }

  @Override
  public FaceDetectEntity getFaceByFaceToken(String faceToken) {
    return this.baseMapper.getFaceByFaceToken(faceToken);
  }
}
