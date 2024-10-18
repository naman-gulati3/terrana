package com.terrana.webtoken;

//@Service
//public class JwtService {
//
//  private static final String JWT_SECRET = "97C303D9E3E10670A2241ADE3E499D881621D943DB8D53D46914E17EBFB524AAC011CD7CA9ACC897F3E7A94696387556FDD04EEA985D4FD4697E88CDCEF5528F";
//  private static final Duration TOKEN_VALIDITY = Duration.ofHours(24);
//
//  public String generateToken(UserDetails userDetails) {
//    Map<String, String> claims = new HashMap<>();
//    claims.put("iss", "www.terrana.in");
//
//    return Jwts.builder().subject(userDetails.getUsername()).issuedAt(Date.from(Instant.now()))
//        .expiration(Date.from(Instant.now().plus(TOKEN_VALIDITY)))
//        .signWith(generateKey())
//        .claims(claims)
//        .compact();
//  }
//
//  private SecretKey generateKey() {
//    byte[] encodedKey = Base64.getDecoder().decode(JWT_SECRET);
//    return Keys.hmacShaKeyFor(encodedKey);
//  }
//}
