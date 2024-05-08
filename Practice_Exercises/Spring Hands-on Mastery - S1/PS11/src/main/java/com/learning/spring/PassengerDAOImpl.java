package com.learning.spring;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component("passengerDAO")
@Scope("singleton")
@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
public class PassengerDAOImpl implements PassengerDAO {

	@Autowired
	@Qualifier("mysqlSessionFactory")
	private SessionFactory sessionFactory;
 
    public int save(Passenger passenger) {
    	return (Integer)sessionFactory.getCurrentSession().save(passenger);
    }

    public void update(Passenger passenger) {
    	sessionFactory.getCurrentSession().saveOrUpdate(passenger);
    }

    public int delete(int id) {
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("DELETE FROM passenger_details WHERE Passenger_id = ?");
        query.setParameter(0, id);
        return query.executeUpdate();
    }

    @Transactional(readOnly = true)
    public Passenger get(int id) {
    	Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from com.learning.spring.Passenger p where p.id=:id");
		query.setParameter("id", id);
		return (Passenger) query.uniqueResult();
    }

    @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
    public List<Passenger> loadAll() {
    	Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Passenger.class);
		return (List<Passenger>)criteria.list();
    }
}
