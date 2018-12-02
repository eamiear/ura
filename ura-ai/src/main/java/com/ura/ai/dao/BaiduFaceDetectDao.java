package com.ura.ai.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ura.ai.entity.FaceDetectEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaiduFaceDetectDao extends BaseMapper<FaceDetectEntity>{
  FaceDetectEntity getFaceByFaceToken(String faceToken);
}
