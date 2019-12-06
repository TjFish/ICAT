package ICAT.backend.shiro.jwt;

import ICAT.backend.pojo.Admin;
import ICAT.backend.pojo.User;
import ICAT.backend.service.AdminService;
import ICAT.backend.service.UserService;
import ICAT.backend.utils.JWTUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class JwtRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(JwtRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account = JWTUtil.getUsername(principals.toString());
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        Admin admin = adminService.getAdminById(account).orElse(null);
        if (admin != null) {
            roles.add("admin");
            permissions.add("admin");
            if (admin.getRole().intValue() == 0) {
                roles.add("admin0");
                permissions.add("admin0");
            } else {
                roles.add("admin1");
                permissions.add("admin1");
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();

        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        User user = userService.getUserById(username).orElse(null);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "jwt_realm");
    }

}