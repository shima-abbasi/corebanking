package corebanking.common.repository;

import corebanking.common.model.Basic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@NoRepositoryBean
public interface BasicRepo<A extends Basic> extends JpaRepository<A, String> {

    default A atomSave(A a) {
        return save(a);
    }


    default A fetch(String id) {
        Optional<A> obj = findById(id);
        return obj.isPresent() ? obj.get() : null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    default A fetchNonTransactional(String id) {
        return fetch(id);
    }

    default A fetchNotDeleted(String id) {
        Optional<A> obj = findById(id);
        return obj.isPresent() && !obj.get().getDeleted() ? obj.get() : null;
    }

    default void logicalDelete(A a) {
        a.setDeleted(Boolean.TRUE);
        atomSave(a);
    }

    default void logicalDeleteById(String pk) {
        A atom = findById(pk).get();
        logicalDelete(atom);
    }

    default void logicalDeleteInBatch(Iterable<A> iterable) {
        for (A a : iterable) {
            a.setDeleted(Boolean.TRUE);
        }
        saveAll(iterable);
    }

}
