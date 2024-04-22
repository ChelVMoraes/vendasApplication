package JavaSpringBootProject.repository;

import JavaSpringBootProject.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Clientes {

    @Autowired
    EntityManager entityManager;

   @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizarCliente(Cliente cliente) {
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public Cliente removerCliente(Cliente cliente){
        if (entityManager.contains(cliente)){
            entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
        return cliente;
    }
    public Cliente removerCliente (Integer id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        removerCliente(cliente);
        return cliente;
    }
    @Transactional
    public List<Cliente> findClienteByName (String name) {
        String jpql = "select * Cliente cli where cli like :nome";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" + name + "%");
        return query.getResultList();
    }

    @Transactional
    public List<Cliente> findTodos () {
       return entityManager.createQuery("from Cliente", Cliente.class).getResultList();

    }



}
