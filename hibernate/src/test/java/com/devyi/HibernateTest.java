package com.devyi;

import com.devyi.pojo.Score;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

    @Test
    public void testInit() {
        Session session = null;
        Transaction tx = null;
        try {
            // 初始化注册服务对象
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // 默认加载 hibernate.cfg.xml 文件，如果配置文件名称被修改，.configure("修改的文件名")
                    .build();

            // 从元信息获取session工厂
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

            //从工厂创建session连接
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();
            Score score = new Score();
            score.setFenshu(88);
            score.setKecheng("sql");
            score.setName("eee");
            session.save(score);
            // 提交事务
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            // 回滚事务
            tx.rollback();
        } finally {
            if (null != session && session.isOpen()) {
                // 关闭session
                session.close();
            }
        }
    }

    @Test
    public void testRead() {
        try {
            // 初始化注册服务对象
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // 默认加载 hibernate.cfg.xml 文件，如果配置文件名称被修改，.configure("修改的文件名")
                    .build();

            // 从元信息获取session工厂
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

            //从工厂创建session连接
            Session session = sessionFactory.openSession();
            Score score = session.get(Score.class, 1);
            System.out.println(score);

            // 关闭session
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
