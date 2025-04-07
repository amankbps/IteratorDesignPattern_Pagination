package org.aman.iterators;

import org.aman.repositories.UserRepository;
import org.aman.repositories.UserRepositoryImpl;

import java.util.List;

public class UserIterator implements Iterator<List<String>>{

   private UserRepository userRepository;
   private int limit=1;
   private int offset=0;
   private List<String>current;

   public UserIterator(int limit) {
       this.userRepository = new UserRepositoryImpl();
       this.limit = limit;
       this.current = userRepository.findUsers(limit,offset);
   }

    @Override
    public boolean hasNext() {
        return !current.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String>result = current;
        this.offset++;
        System.out.println(limit+" "+offset);
        this.current=this.userRepository.findUsers(limit,offset);
        return result;
    }
}
