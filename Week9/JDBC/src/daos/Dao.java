package daos;

public interface Dao<T, PK> {
    List<T> findAll();
    T findById(PK pk);
    void insert(T item);
    Boolean update(T item);
    Boolean delete(PK pk);
    
}
