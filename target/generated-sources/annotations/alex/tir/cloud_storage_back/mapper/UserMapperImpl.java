package alex.tir.cloud_storage_back.mapper;

import alex.tir.cloud_storage_back.dto.UserInfo;
import alex.tir.cloud_storage_back.entity.Role;
import alex.tir.cloud_storage_back.entity.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-07T18:11:55+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserInfo mapUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setDateRegistered( user.getDateCreated() );
        userInfo.setId( user.getId() );
        userInfo.setEmail( user.getEmail() );
        userInfo.setFirstName( user.getFirstName() );
        userInfo.setLastName( user.getLastName() );
        userInfo.setDateModified( user.getDateModified() );
        userInfo.setRoles( roleSetToStringSet( user.getRoles() ) );

        return userInfo;
    }

    @Override
    public List<UserInfo> mapUsers(Iterable<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserInfo> list = new ArrayList<UserInfo>();
        for ( User user : users ) {
            list.add( mapUser( user ) );
        }

        return list;
    }

    protected Set<String> roleSetToStringSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<String> set1 = new HashSet<String>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToString( role ) );
        }

        return set1;
    }
}
