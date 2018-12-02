package com.ura.ai.bean;

import java.util.List;

public class FaceDetectBean {
  private int error_code;
  private String error_msg;
  private long log_id;
  // 时间戳
  private long timestamp;
  // 缓存
  private int cached;
  // 数据集
  private Result result;

  public int getError_code() {
    return error_code;
  }

  public void setError_code(int error_code) {
    this.error_code = error_code;
  }

  public String getError_msg() {
    return error_msg;
  }

  public void setError_msg(String error_msg) {
    this.error_msg = error_msg;
  }

  public long getLog_id() {
    return log_id;
  }

  public void setLog_id(long log_id) {
    this.log_id = log_id;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public int getCached() {
    return cached;
  }

  public void setCached(int cached) {
    this.cached = cached;
  }

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  public static class Result {
    private int face_num;
    private List<Face_list> face_list;

    public int getFace_num() {
      return face_num;
    }

    public void setFace_num(int face_num) {
      this.face_num = face_num;
    }

    public List<Face_list> getFace_list() {
      return face_list;
    }

    public void setFace_list(List<Face_list> face_list) {
      this.face_list = face_list;
    }
  }

  public static class Face_list {
    // 人脸图片的唯一标识
    private String face_token;
    // 人脸在图片中的位置
    private Location location;
    // 人脸置信度，范围【0~1】，代表这是一张人脸的概率，0最小、1最大。
    private int face_probability;
    // 人脸旋转角度参数
    private Angle angle;
    // 年龄
    private int age;
    // 美丑打分，范围0-100，越大表示越美。
    private double beauty;
    // 表情
    private Expression expression;
    // 脸型
    private Face_shape face_shape;
    // 性别
    private Gender gender;
    // 是否带眼镜
    private Glasses glasses;
    // 4个关键点位置，左眼中心、右眼中心、鼻尖、嘴中心
    private List<Landmark> landmark;
    // 72个特征点位置
    private List<Landmark72> landmark72;
    // 人种
    private Race race;

    public String getFace_token() {
      return face_token;
    }

    public void setFace_token(String face_token) {
      this.face_token = face_token;
    }

    public Location getLocation() {
      return location;
    }

    public void setLocation(Location location) {
      this.location = location;
    }

    public int getFace_probability() {
      return face_probability;
    }

    public void setFace_probability(int face_probability) {
      this.face_probability = face_probability;
    }

    public Angle getAngle() {
      return angle;
    }

    public void setAngle(Angle angle) {
      this.angle = angle;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public double getBeauty() {
      return beauty;
    }

    public void setBeauty(double beauty) {
      this.beauty = beauty;
    }

    public Expression getExpression() {
      return expression;
    }

    public void setExpression(Expression expression) {
      this.expression = expression;
    }

    public Face_shape getFace_shape() {
      return face_shape;
    }

    public void setFace_shape(Face_shape face_shape) {
      this.face_shape = face_shape;
    }

    public Gender getGender() {
      return gender;
    }

    public void setGender(Gender gender) {
      this.gender = gender;
    }

    public Glasses getGlasses() {
      return glasses;
    }

    public void setGlasses(Glasses glasses) {
      this.glasses = glasses;
    }

    public List<Landmark> getLandmark() {
      return landmark;
    }

    public void setLandmark(List<Landmark> landmark) {
      this.landmark = landmark;
    }

    public List<Landmark72> getLandmark72() {
      return landmark72;
    }

    public void setLandmark72(List<Landmark72> landmark72) {
      this.landmark72 = landmark72;
    }

    public Race getRace() {
      return race;
    }

    public void setRace(Race race) {
      this.race = race;
    }
  }

  public static class Location {
    private double left;
    private double top;
    private int width;
    private int height;
    private int rotation;

    public double getLeft() {
      return left;
    }

    public void setLeft(double left) {
      this.left = left;
    }

    public double getTop() {
      return top;
    }

    public void setTop(double top) {
      this.top = top;
    }

    public int getWidth() {
      return width;
    }

    public void setWidth(int width) {
      this.width = width;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

    public int getRotation() {
      return rotation;
    }

    public void setRotation(int rotation) {
      this.rotation = rotation;
    }
  }

  public static class Angle {
    private double yaw;
    private double pitch;
    private double roll;

    public double getYaw() {
      return yaw;
    }

    public void setYaw(double yaw) {
      this.yaw = yaw;
    }

    public double getPitch() {
      return pitch;
    }

    public void setPitch(double pitch) {
      this.pitch = pitch;
    }

    public double getRoll() {
      return roll;
    }

    public void setRoll(double roll) {
      this.roll = roll;
    }
  }

  public static class Expression {
    private String type;
    private double probability;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public double getProbability() {
      return probability;
    }

    public void setProbability(double probability) {
      this.probability = probability;
    }
  }

  public static class Face_shape {
    private String type;
    private double probability;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public double getProbability() {
      return probability;
    }

    public void setProbability(double probability) {
      this.probability = probability;
    }
  }

  public static class Gender {
    private String type;
    private double probability;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public double getProbability() {
      return probability;
    }

    public void setProbability(double probability) {
      this.probability = probability;
    }
  }

  public static class Glasses {
    private String type;
    private double probability;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public double getProbability() {
      return probability;
    }

    public void setProbability(double probability) {
      this.probability = probability;
    }
  }

  public static class Landmark {
    private double x;
    private double y;

    public double getX() {
      return x;
    }

    public void setX(double x) {
      this.x = x;
    }

    public double getY() {
      return y;
    }

    public void setY(double y) {
      this.y = y;
    }
  }

  public static class Landmark72 {
    private double x;
    private double y;

    public double getX() {
      return x;
    }

    public void setX(double x) {
      this.x = x;
    }

    public double getY() {
      return y;
    }

    public void setY(double y) {
      this.y = y;
    }
  }

  public static class Race {
    private String type;
    private double probability;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public double getProbability() {
      return probability;
    }

    public void setProbability(double probability) {
      this.probability = probability;
    }
  }
}


