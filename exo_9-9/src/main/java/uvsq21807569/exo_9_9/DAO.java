package uvsq21807569.exo_9_9;

public interface DAO<T> {

	T create(T obj) ;

	T read(String id);

	T update(T obj);

	void delete(T obj);
}
