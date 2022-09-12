package com.api.bravecoin.dto;

import java.util.ArrayList;

public class JwtDecoderDTO{
	public String jti;
    public String sub;
    public ArrayList<String> authorities;
    public int iat;
    public int exp;
    
}