package com.team.experimentstests;

import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.audits.Audits;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.SetCookieBlockedReason;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Exp extends BaseExperiment {

    @Test
    public void xxx() {
        DevTools devTools = getWebDriver().getDevTools();
        devTools.createSession();
        ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
        SetCookieBlockedReason[] setCookieBlockedReasonArray = {SetCookieBlockedReason.SAMESITENONEINSECURE};
     //   params.put("blockedReasons", setCookieBlockedReasonArray);
   //     params.put("cookieLine", "");

      //  Network.getAllCookies()



       // Command command = new Command("Audits.CookieExclusionReason", params.build());
        devTools.send(Network.clearBrowserCache());

      //  getWebDriver().executeCdpCommand("Network.BlockedSetCookieWithReason",params.build());

    }

    @Test
    public void mockGeoLocation_executeCDPCommand(){
        Map coordinates = new HashMap();
//        {{
//            put("latitude", 32.746940);
//            put("longitude", -97.092400);
//            put("accuracy", 1);
//        }};
  //      getWebDriver().executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
  //      getWebDriver().get("https://where-am-i.org/");
    }
}
