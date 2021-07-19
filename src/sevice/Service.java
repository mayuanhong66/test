package sevice;

import dao.Dao;
import entity.Account;

import java.util.List;

public class Service {
        Dao dao=new Dao();

        public List<Account> show(String name) {
            return dao.show(name);
        }

        public int update(Account account) {
            int f=0;
            if(dao.update(account)) {
                f=1;
            }
            return f;
        }

        public int delete(String name) {
            int f=0;
            if(dao.delete(name)) {
                f=1;
            }
            return f;
        }

        public int add(Account account) {
            int f=0;
            if(!dao.rename(account.getName())) {
                f=1;
                if(dao.add(account)) f=2;
            }
            return f;
        }


        public Account getByname(String name) {
            return dao.getByname(name);
        }

        public List<Account> list() {
            // TODO 自动生成的方法存根
            return dao.list();
        }

        public Account getByname2(String name) {
            // TODO 自动生成的方法存根
            return dao.getByname2(name);
        }

    }

