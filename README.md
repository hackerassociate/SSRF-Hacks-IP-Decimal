# 🌐 SSRF-Hacks-IP-Decimal
A Burp Suite extension that converts IP addresses to decimal notation, useful for SSRF bypass and WAF evasion testing. 
Created by Harshad Shah. ✨

# 🛠️ IP to Decimal Converter - Burp Suite Extension

## 📜 Description
The IP to Decimal Converter is a Burp Suite extension that allows security professionals and penetration testers to automatically convert IP addresses to their decimal notation format. 🔄 This tool is particularly useful for bypassing security controls that block regular IP addresses but may not recognize decimal notation. 🚀

✍️ Author
Name: Harshad Shah 👤 [ www.hackerassociate.com ] 

![SSRF Screenshot](https://github.com/hackerassociate/SSRF-Hacks-IP-Decimal](https://github.com/hackerassociate/SSRF-Hacks-IP-Decimal/blob/main/Hacker-Associate-SSRF.png)

## 🌟 Features
- 🔢 Converts IPv4 addresses to decimal notation
- 📋 Context menu integration in Burp Suite
- 🔄 Automatic replacement of IPs in requests
- 📊 Real-time conversion logging
- 🖥️ Simple and intuitive user interface

## 💡 Use Cases
- 🕵️‍♂️ SSRF (Server-Side Request Forgery) bypass attempts
- 🔐 WAF (Web Application Firewall) evasion testing
- ✅ Security control validation
- 🌐 Network security assessments

## 📥 Installation
1. 📥 Download the latest release (`SSRF-Bugbounty-IP-DECIMAL-by-Harshad.jar`)
2. 🛠️ Open Burp Suite Professional
3. 📂 Navigate to the Extender tab
4. ➕ Click the "Add" button
5. 📁 Select the downloaded JAR file
6. 🚀 The extension will be loaded automatically

## ⚙️ Usage
1. 🖱️ Right-click on any request in Burp Suite
2. 📜 Select "Convert IP to Decimal" from the context menu
3. The extension will automatically:
   - 🔍 Identify all IP addresses in the request
   - 🔄 Convert them to decimal notation
   - 🔄 Replace the original IPs with their decimal equivalents
   - 📜 Log the conversions in the extension output
