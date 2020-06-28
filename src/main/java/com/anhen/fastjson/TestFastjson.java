package com.anhen.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestFastjson
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/4/18 18:02
 * @Version 1.0
 *
 **/

/*      fastJson对于json格式字符串的解析主要用到了一下三个类：
        JSON：fastJson的解析器，用于JSON格式字符串与JSON对象及javaBean之间的转换。
        JSONObject：fastJson提供的json对象。
        JSONArray：fastJson提供json数组对象。
        我们可以把JSONObject当成一个Map<String,Object>来看，只是JSONObject提供了更为丰富便捷的方法，方便我们对于对象属性的操作。我们看一下源码。
        同样我们可以把JSONArray当做一个List<Object>，可以把JSONArray看成JSONObject对象的一个集合。
        此外，由于JSONObject和JSONArray继承了JSON，所以说也可以直接使用两者对JSON格式字符串与JSON对象及javaBean之间做转换，不过为了避免混淆我们还是使用JSON。
 */

public class TestFastjson {

    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {
//        testJSONStrToJSONObject();
//        testJSONStrToJSONArray();
//        testJSONStrToJavaBeanList();
        testJSONStrToJavaBeanObj();
//        testJSONStrToJavaBeanList();
    }

    /**
     * json字符串-简单对象型与JSONObject之间的转换
     */
    public static void testJSONStrToJSONObject(){
        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        //
        System.out.println(jsonObject.toJSONString());
    }

    /**
     * json字符串-数组类型与JSONArray之间的转换
     */
    public static void testJSONStrToJSONArray(){

        JSONArray jsonArray = JSON.parseArray(JSON_ARRAY_STR);
        //JSONArray jsonArray1 = JSONArray.parseArray(JSON_ARRAY_STR);//因为JSONArray继承了JSON，所以这样也是可以的

        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }

        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }

        jsonArray.forEach(x-> System.out.println(((JSONObject)x).getString("studentName")+":"+((JSONObject)x).getInteger("studentAge")));

        //
        System.out.println(jsonArray.toJSONString());
    }


    /**
     * 复杂json格式字符串与JSONObject之间的转换
     */
    public static void testComplexJSONStrToJSONObject(){

        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(COMPLEX_JSON_STR);//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students = jsonObject.getJSONArray("students");

        System.out.println(jsonObject.toJSONString());
    }

    /**
     * json字符串-简单对象与JavaBean_obj之间的转换
     */
    public static void testJSONStrToJavaBeanObj(){

        Student student = JSON.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});
//        Student student = JSON.parseObject(JSON_OBJ_STR, Student.class);
        //Student student1 = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        System.out.println(student.getStudentName()+":"+student.getStudentAge());

        //
        System.out.println(JSON.toJSONString(student));

        JSONObject jsonObject = (JSONObject) JSON.toJSON(student);
        System.out.println(jsonObject.toJSONString());
    }

    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    public static void testJSONStrToJavaBeanList(){

        ArrayList<Student> students = JSON.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        //ArrayList<Student> students1 = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});//因为JSONArray继承了JSON，所以这样也是可以的

        for (Student student : students) {
            System.out.println(student.getStudentName()+":"+student.getStudentAge());
        }

        System.out.println(JSON.toJSONString(students));
    }

    /**
     * 复杂json格式字符串与JavaBean_obj之间的转换
     */
    public static void testComplexJSONStrToJavaBean(){

        Teacher teacher = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        //Teacher teacher1 = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = teacher.getTeacherName();
        Integer teacherAge = teacher.getTeacherAge();
        Course course = teacher.getCourse();
        List<Student> students = teacher.getStudents();
    }

}

