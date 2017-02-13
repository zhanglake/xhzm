package com.xhzm.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.xhzm.dto.OrderDetailDto;
import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public List<Order> findAllOrderByCustomerId(int id) {
		List<Order> orders = new ArrayList<Order>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		String hql = "from Order as o where o.customerId = :id order by o.orderId desc";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		List list = query.list();
		for (Object o : list) {
			Order order = (Order) o;
			orders.add(order);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orders;
	}

	@Override
	public List<OrderDetail> findOrderDetails(int orderId) {
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		String hql = "from OrderDetail as ol where ol.orderId = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", orderId);
		List list = query.list();
		for (Object o : list) {
			OrderDetail orderDetail = (OrderDetail) o;
			orderDetails.add(orderDetail);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orderDetails;
	}

	@Override
	public void saveOrder(Double totalPrice, int orderCustomerId,
			String deliveryDate, String orderDescription) {
		
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql1 = "insert into orders (customer_id, created_date, delivery_date, description, total_price) values (?,?,?,?,?)";
		Query query1 = session.createSQLQuery(sql1);
		query1.setParameter(0, orderCustomerId);
		query1.setParameter(1, sdf.format(new Date()));
		query1.setParameter(2, deliveryDate.trim());
		query1.setParameter(3, orderDescription.trim());
		query1.setParameter(4, totalPrice);
		query1.executeUpdate();

		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public int getNewOrderId() {

		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();

		// ��ȡ�մ��Orders���Id
		String hql = "from Order as o order by o.createDate desc limit 1";
		Query query2 = session.createQuery(hql);
		List list = query2.list();
		int orderId = 0;
		Order order = (Order) list.get(0);
		orderId = order.getOrderId();
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orderId;
	}

	@Override
	public void saveOrderDetail(List<String> lamp, List<String> price,
			List<String> number, List<String> description, int orderId) {

		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();

		// ��Order_lamp��
		for (int i = 0; i < lamp.size(); i++) {
			System.out.println(lamp.get(i) +","+ price.get(i) +","+ number.get(i) +","+ description.get(i) +","+ orderId);
			String sql = "insert into order_detail (lamp, price, number, description, order_id) values (?,?,?,?,?)";
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, lamp.get(i).trim());
			query.setParameter(1, price.get(i).trim());
			query.setParameter(2, number.get(i).trim());
			query.setParameter(3, description.get(i).trim());
			query.setParameter(4, orderId);
			query.executeUpdate();
		}

		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void createOrderDetails(List<OrderDetailDto> orderDetailDtos, int orderId) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		
		for (OrderDetailDto orderDetail : orderDetailDtos) {
			String sql = "insert into order_detail (lamp, price, number, description, order_id) values (?,?,?,?,?)";
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, orderDetail.getLampName().trim());
			query.setParameter(1, orderDetail.getLampPrice());
			query.setParameter(2, orderDetail.getLampNumber());
			query.setParameter(3, orderDetail.getLampDesc().trim());
			query.setParameter(4, orderId);
			query.executeUpdate();
		}
		
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
