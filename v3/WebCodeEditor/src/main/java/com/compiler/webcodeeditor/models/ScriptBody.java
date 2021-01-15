/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compiler.webcodeeditor.models;

/**
 *
 * @author ISO
 */
public class ScriptBody {
    String clientId;
    String clientSecret;
    String script;
    String language;
    int versionIndex;

    public ScriptBody(String clientId, String clientSecret, String script, String language, int versionIndex) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.script = script;
        this.language = language;
        this.versionIndex = versionIndex;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getVersionIndex() {
        return versionIndex;
    }

    public void setVersionIndex(int versionIndex) {
        this.versionIndex = versionIndex;
    }
    
    
}
