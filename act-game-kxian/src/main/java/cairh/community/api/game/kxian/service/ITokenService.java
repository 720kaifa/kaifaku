package cairh.community.api.game.kxian.service;

import java.util.Map;

/**
 * 解析海通的token
 * @author cql
 *
 */
public interface ITokenService {

	String anlyToken(String token);

	Map<String, Object> getUserInfoByToken(String token);
}
