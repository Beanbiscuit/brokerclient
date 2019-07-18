package com.beanbiscuit.moneytree.brokerclient;

import com.beanbiscuit.moneytree.brokerclient.api.authentication.AuthenticationException;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.AuthenticationStrategy;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiSession;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.OAuthTokenAccess;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApiClientTest {

    private ApiClient client;

    private AuthenticationStrategy authenticationStrategy;

    private IGApiSession session;

    @Before
    public void setUp() {
        this.authenticationStrategy = Mockito.mock(OAuthTokenAccess.class);
        this.session = Mockito.mock(IGApiSession.class);

        this.client = ApiClient.newInstance("", "", "", "");
        this.client.setAuthentication(this.authenticationStrategy);
    }

    @Test
    public void authenticate() throws AuthenticationException {
        when(
            this.authenticationStrategy.authentication(null, null, null, null)
        ).thenReturn(this.session);

        final IGApiSession session = this.client.authenticate();

        verify(this.authenticationStrategy.authentication(null, null, null, null));
    }
}