package com.learnnote;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class DataComp {

   static Random random;
   static String[] array = new String[] {"teacher wang","teacher li","teacher liu","teacher chen","teacher yang","teacher song","teacher hao","teacher zhang","teacher zhou"};
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        String url="jdbc:mysql://123.56.19.150:3306/chen?useSSL=false&serverTimezone=UTC";
        String url1="jdbc:mysql://123.56.19.150:3306/information_schema?useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="Yangluoqi@yang7";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url,user,password);
        Connection conn1= DriverManager.getConnection(url1,user,password);
        //创建数据表
        String createSQL="create table data_comp ( id int AUTO_INCREMENT primary key, name varchar(20),chinese double,math double,english double,favor_teacher varchar(30));";
System.out.println(createSQL);
        Statement statement = conn.createStatement();
        boolean execute = statement.execute(createSQL);
        System.out.println(execute);

        //插入数据

        String sql = "insert into data_comp (name,chinese,math,english,favor_teacher)values (?,?,?,?,?)";
        String name="yangjiajin";
        for(int i=0;i<100;i++){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name+i);
            preparedStatement.setDouble(2,generateRandomNum());
            preparedStatement.setDouble(3, generateRandomNum());
            preparedStatement.setDouble(4,generateRandomNum());
            preparedStatement.setString(5,generateTeacher());
            preparedStatement.executeUpdate();
        }


        //取数据
        //取表头
        String titleSQL="select COLUMN_NAME from columns where table_name='data_comp';";
        Statement statement1 = conn1.createStatement();
        ResultSet rs=statement1.executeQuery(titleSQL);
        ArrayList<String> titleList=new ArrayList<>();
        while(rs.next()){
            titleList.add(rs.getString(1));

        }
        System.out.println("titleList: "+titleList);

        //随机取两行
        int row1=generateRandomRow();
        int row2=generateRandomRow();
        String getRow1SQL="select * from data_comp where id="+row1;
        String getRow2SQL="select * from data_comp where id="+row2;
        ResultSet resultSet1 = statement.executeQuery(getRow1SQL);
        ArrayList<String> array1=new ArrayList<>();
        while(resultSet1.next()){
            array1.add(resultSet1.getString(1)) ;
            array1.add(resultSet1.getString(2)) ;
            array1.add(resultSet1.getString(3)) ;
            array1.add(resultSet1.getString(4)) ;
            array1.add(resultSet1.getString(5)) ;

        }
System.out.println("array1: "+array1);
        ResultSet resultSet2 = statement.executeQuery(getRow2SQL);
        ArrayList<String> array2=new ArrayList<>();
        while(resultSet2.next()){
            array2.add(resultSet2.getString(1));
            array2.add(resultSet2.getString(2));
            array2.add(resultSet2.getString(3));
            array2.add(resultSet2.getString(4));
            array2.add(resultSet2.getString(5));

        }
        System.out.println("array2: "+array2);
        compList(array1,array2);


        conn.close();
conn1.close();

    }

    public static float generateRandomNum(){
        random=new Random();
        float randomNum=random.nextInt(100);
        return randomNum;

    }

    public static String generateTeacher(){

        random=new Random();
        int randomNum=random.nextInt(array.length);
        return array[randomNum];

    }

    public static ArrayList<ArrayList<String>> compList(ArrayList<String> array1,ArrayList<String> array2) throws InterruptedException {
        ArrayList<ArrayList<String>> result=new ArrayList<>();
        result.add(array1);
        System.out.println(array1);
        System.out.print("["+array2.get(0));
        for(int i=1;i<array1.size();i++){
            if(!array1.get(i).equals(array2.get(i))){
                System.out.print(", ");
                Thread.sleep(10l);
                System.err.print(array2.get(i));
               Thread.sleep(10l);
            }else{

                System.out.print(", "+array2.get(i));
                Thread.sleep(10l);
            }

        }
        System.out.print("]");
        Thread.sleep(10l);
return result;
    }


    public static int generateRandomRow(){
        random=new Random();
        int randomRow=random.nextInt(100);
        return randomRow;

    }


}
