/* IRepository.java
Author: Agnes Mabusela (230020690)
Date: 26/03/2025
 */
package za.ac.cput.repository;

public interface IRepository<T, ID> {

    T create( T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

}
