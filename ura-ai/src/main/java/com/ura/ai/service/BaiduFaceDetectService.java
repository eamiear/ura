package com.ura.ai.service;

import com.baomidou.mybatisplus.service.IService;
import com.ura.ai.entity.FaceDetectEntity;

public interface BaiduFaceDetectService extends IService<FaceDetectEntity> {

  boolean save(FaceDetectEntity faceDetectEntity);

  FaceDetectEntity getFaceByFaceToken(String faceToken);
}
