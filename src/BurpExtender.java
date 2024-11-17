package burp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BurpExtender implements IBurpExtender, IContextMenuFactory {
    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;

    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        
        // Set extension name
        callbacks.setExtensionName("SSRF Hacks IP-Decimal by Harshad");
        
        // Register context menu
        callbacks.registerContextMenuFactory(this);
        
        // Print extension information
        callbacks.printOutput("SSRFIP to Decimal Converter - Loaded successfully!");
        callbacks.printOutput("Created by: Harshad Shah");
        callbacks.printOutput("Website: www.hackerassociate.com");
    }

    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        List<JMenuItem> menuList = new ArrayList<JMenuItem>();
        JMenuItem menuItem = new JMenuItem("Convert IP to Decimal");
        menuItem.addActionListener(e -> convertIpToDecimal(invocation));
        menuList.add(menuItem);
        return menuList;
    }

    private void convertIpToDecimal(IContextMenuInvocation invocation) {
        IHttpRequestResponse[] messages = invocation.getSelectedMessages();
        
        for (IHttpRequestResponse message : messages) {
            if (message.getRequest() != null) {
                byte[] request = message.getRequest();
                String requestStr = new String(request);
                
                // Find IP addresses using regex
                Pattern pattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
                Matcher matcher = pattern.matcher(requestStr);
                
                while (matcher.find()) {
                    String ip = matcher.group();
                    String[] octets = ip.split("\\.");
                    long decimal = (Long.parseLong(octets[0]) * 16777216 +
                                  Long.parseLong(octets[1]) * 65536 +
                                  Long.parseLong(octets[2]) * 256 +
                                  Long.parseLong(octets[3]));
                    
                    callbacks.printOutput("IP Address: " + ip + " -> Decimal: " + decimal);
                    requestStr = requestStr.replace(ip, String.valueOf(decimal));
                }
                
                message.setRequest(requestStr.getBytes());
            }
        }
    }
}