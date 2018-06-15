// Javadoc built-in javascript code
function show(type) {
	count = 0;
	for (var key in methods) {
		var row = document.getElementById(key);
		if ((methods[key] & type) != 0) {
			row.style.display = '';
			row.className = (count++ % 2) ? rowColor : altColor;
		} else row.style.display = 'none';
	}
	updateTabs(type);
}

function updateTabs(type) {
	for (var value in tabs) {
		var sNode = document.getElementById(tabs[value][0]);
		var spanNode = sNode.firstChild;
		if (value == type) {
			sNode.className = activeTableTab;
			spanNode.innerHTML = tabs[value][1];
		} else {
			sNode.className = tableTab;
			spanNode.innerHTML = "<a href=\"javascript:show(" + value + ");\">" + tabs[value][1] + "</a>";
		}
	}
}
// My Functions
function showAnnouncement() {
	if (window.name != "classFrame" && window.name.length != 0) return;
	ajax().get("https://docs.windit.net/Chinese_BukkitAPI/announcement").then(function (response, xhr) {
		if (!response.showAnnouncement) {
			return
		}
		if (Cookies.get("ignored_announcement") == response.lastUpdated) {
			Cookies.set("ignored_announcement", response.lastUpdated, { expires: 30 });
			return;
		}
		swal({
			title: "公告",
			html: true,
			text: response.message,
			confirmButtonText: "知道了(本公告将不再提示)"
		}, function () {
			Cookies.set("ignored_announcement", response.lastUpdated, { expires: 30 });
		});
	});
}
function loadcomment() {
	if (document.getElementById("SOHUCS")) return;

	var contentContainers = document.getElementsByClassName("contentContainer");
	if (contentContainers.length > 0) {
		var lastContentContainer = contentContainers[contentContainers.length - 1];
		var div = document.createElement("div");
		div.setAttribute("id", "SOHUCS");
		var loc = window.location;
		if (loc.pathname.indexOf("org") > 0) {
			div.setAttribute("sid", loc.pathname.slice(window.location.pathname.indexOf("org")));
		} else {
			div.setAttribute("sid", window.location.pathname.slice(window.location.pathname.lastIndexOf("/") + 1));
		}
		lastContentContainer.appendChild(div);
		$script("https://changyan.sohu.com/upload/changyan.js", function () {
			var script = document.createElement("script");
			script.innerHTML = "window.changyan.api.config({\
            appid: 'cyt5tMDqL',\
            conf: 'prod_1dc953f5be68de59e7af0d96b732e4c1'\
            });";
			lastContentContainer.appendChild(script);
		});
		$script(["https://changyan.sohu.com/upload/changyan.js","https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js","https://www.googletagmanager.com/gtag/js?id=UA-113488090-1"], function () {
			var script = document.createElement("script");
			script.innerHTML = "window.changyan.api.config({\
            appid: 'cyt5tMDqL',\
            conf: 'prod_1dc953f5be68de59e7af0d96b732e4c1'\
            });\
  (adsbygoogle = window.adsbygoogle || []).push({\
    google_ad_client: \"ca-pub-3420822492072643\",\
    enable_page_level_ads: true\
  });\
  window.dataLayer = window.dataLayer || [];\
  function gtag(){dataLayer.push(arguments);}\
  gtag('js', new Date());\
  gtag('config', 'UA-113488090-1');";
			lastContentContainer.appendChild(script);
		});
	}
}
// js-cookie start
/*! js-cookie v2.1.4 | MIT */
!function (a) { var b = !1; if ("function" == typeof define && define.amd && (define(a), b = !0), "object" == typeof exports && (module.exports = a(), b = !0), !b) { var c = window.Cookies, d = window.Cookies = a(); d.noConflict = function () { return window.Cookies = c, d } } }(function () { function a() { for (var a = 0, b = {}; a < arguments.length; a++) { var c = arguments[a]; for (var d in c) b[d] = c[d] } return b } function b(c) { function d(b, e, f) { var g; if ("undefined" != typeof document) { if (arguments.length > 1) { if (f = a({ path: "/" }, d.defaults, f), "number" == typeof f.expires) { var h = new Date; h.setMilliseconds(h.getMilliseconds() + 864e5 * f.expires), f.expires = h } f.expires = f.expires ? f.expires.toUTCString() : ""; try { g = JSON.stringify(e), /^[\{\[]/.test(g) && (e = g) } catch (p) { } e = c.write ? c.write(e, b) : encodeURIComponent(e + "").replace(/%(23|24|26|2B|3A|3C|3E|3D|2F|3F|40|5B|5D|5E|60|7B|7D|7C)/g, decodeURIComponent), b = encodeURIComponent(b + ""), b = b.replace(/%(23|24|26|2B|5E|60|7C)/g, decodeURIComponent), b = b.replace(/[\(\)]/g, escape); var i = ""; for (var j in f) f[j] && (i += "; " + j, !0 !== f[j] && (i += "=" + f[j])); return document.cookie = b + "=" + e + i } b || (g = {}); for (var k = document.cookie ? document.cookie.split("; ") : [], l = 0; l < k.length; l++) { var m = k[l].split("="), n = m.slice(1).join("="); '"' === n.charAt(0) && (n = n.slice(1, -1)); try { var o = m[0].replace(/(%[0-9A-Z]{2})+/g, decodeURIComponent); if (n = c.read ? c.read(n, o) : c(n, o) || n.replace(/(%[0-9A-Z]{2})+/g, decodeURIComponent), this.json) try { n = JSON.parse(n) } catch (p) { } if (b === o) { g = n; break } b || (g[o] = n) } catch (p) { } } return g } } return d.set = d, d.get = function (a) { return d.call(d, a) }, d.getJSON = function () { return d.apply({ json: !0 }, [].slice.call(arguments)) }, d.defaults = {}, d.remove = function (b, c) { d(b, "", a(c, { expires: -1 })) }, d.withConverter = b, d } return b(function () { }) });
// js-cookie end
// ajax start
/**!
 * ajax - v2.1.6
 * Ajax module in Vanilla JS
 * https://github.com/fdaciuk/ajax

 * Wed May 24 2017 22:40:49 GMT-0300 (BRT)
 * MIT (c) Fernando Daciuk
*/
!function (e, t) { "use strict"; "function" == typeof define && define.amd ? define("ajax", t) : "object" == typeof exports ? exports = module.exports = t() : e.ajax = t() }(this, function () { "use strict"; function e(e) { var r = ["get", "post", "put", "delete"]; return e = e || {}, e.baseUrl = e.baseUrl || "", e.method && e.url ? n(e.method, e.baseUrl + e.url, t(e.data), e) : r.reduce(function (r, o) { return r[o] = function (r, u) { return n(o, e.baseUrl + r, t(u), e) }, r }, {}) } function t(e) { return e || null } function n(e, t, n, o) { var a = ["then", "catch", "always"], s = a.reduce(function (e, t) { return e[t] = function (n) { return e[t] = n, e }, e }, {}), i = new XMLHttpRequest; return i.open(e, t, !0), i.withCredentials = o.hasOwnProperty("withCredentials"), r(i, o.headers), i.addEventListener("readystatechange", u(s, i), !1), i.send(c(n)), s.abort = function () { return i.abort() }, s } function r(e, t) { t = t || {}, o(t) || (t["Content-Type"] = "application/x-www-form-urlencoded"), Object.keys(t).forEach(function (n) { t[n] && e.setRequestHeader(n, t[n]) }) } function o(e) { return Object.keys(e).some(function (e) { return "content-type" === e.toLowerCase() }) } function u(e, t) { return function n() { t.readyState === t.DONE && (t.removeEventListener("readystatechange", n, !1), e.always.apply(e, a(t)), t.status >= 200 && t.status < 300 ? e.then.apply(e, a(t)) : e["catch"].apply(e, a(t))) } } function a(e) { var t; try { t = JSON.parse(e.responseText) } catch (n) { t = e.responseText } return [t, e] } function c(e) { return s(e) ? i(e) : e } function s(e) { return "[object Object]" === Object.prototype.toString.call(e) } function i(e) { return Object.keys(e).reduce(function (t, n) { var r = t ? t + "&" : ""; return r + f(n) + "=" + f(e[n]) }, "") } function f(e) { return encodeURIComponent(e) } return e });
// ajax end
// $script.js - start
/*!
  * $script.js JS loader & dependency manager
  * https://github.com/ded/script.js
  * (c) Dustin Diaz 2014 | License MIT
  */
(function (e, t) { typeof module != "undefined" && module.exports ? module.exports = t() : typeof define == "function" && define.amd ? define(t) : this[e] = t() })("$script", function () { function p(e, t) { for (var n = 0, i = e.length; n < i; ++n)if (!t(e[n])) return r; return 1 } function d(e, t) { p(e, function (e) { return t(e), 1 }) } function v(e, t, n) { function g(e) { return e.call ? e() : u[e] } function y() { if (!--h) { u[o] = 1, s && s(); for (var e in f) p(e.split("|"), g) && !d(f[e], g) && (f[e] = []) } } e = e[i] ? e : [e]; var r = t && t.call, s = r ? t : n, o = r ? e.join("") : t, h = e.length; return setTimeout(function () { d(e, function t(e, n) { if (e === null) return y(); !n && !/^https?:\/\//.test(e) && c && (e = e.indexOf(".js") === -1 ? c + e + ".js" : c + e); if (l[e]) return o && (a[o] = 1), l[e] == 2 ? y() : setTimeout(function () { t(e, !0) }, 0); l[e] = 1, o && (a[o] = 1), m(e, y) }) }, 0), v } function m(n, r) { var i = e.createElement("script"), u; i.onload = i.onerror = i[o] = function () { if (i[s] && !/^c|loade/.test(i[s]) || u) return; i.onload = i[o] = null, u = 1, l[n] = 2, r() }, i.async = 1, i.src = h ? n + (n.indexOf("?") === -1 ? "?" : "&") + h : n, t.insertBefore(i, t.lastChild) } var e = document, t = e.getElementsByTagName("head")[0], n = "string", r = !1, i = "push", s = "readyState", o = "onreadystatechange", u = {}, a = {}, f = {}, l = {}, c, h; return v.get = m, v.order = function (e, t, n) { (function r(i) { i = e.shift(), e.length ? v(i, r) : v(i, t, n) })() }, v.path = function (e) { c = e }, v.urlArgs = function (e) { h = e }, v.ready = function (e, t, n) { e = e[i] ? e : [e]; var r = []; return !d(e, function (e) { u[e] || r[i](e) }) && p(e, function (e) { return u[e] }) ? t() : !function (e) { f[e] = f[e] || [], f[e][i](t), n && n(r) }(e.join("|")), v }, v.done = function (e) { v([null], e) }, v })
// $script.js - end
// domready start
/*!
  * domready (c) Dustin Diaz 2014 - License MIT
  */
!function (e, t) { typeof module != "undefined" ? module.exports = t() : typeof define == "function" && typeof define.amd == "object" ? define(t) : this[e] = t() }("domready", function () { var e = [], t, n = document, r = n.documentElement.doScroll, i = "DOMContentLoaded", s = (r ? /^loaded|^c/ : /^loaded|^i|^c/).test(n.readyState); return s || n.addEventListener(i, t = function () { n.removeEventListener(i, t), s = 1; while (t = e.shift()) t() }), function (t) { s ? setTimeout(t, 0) : e.push(t) } })
// domready end
// SweetAlert start
!function (e, t, n) { "use strict"; !function o(e, t, n) { function a(s, l) { if (!t[s]) { if (!e[s]) { var i = "function" == typeof require && require; if (!l && i) return i(s, !0); if (r) return r(s, !0); var u = new Error("Cannot find module '" + s + "'"); throw u.code = "MODULE_NOT_FOUND", u } var c = t[s] = { exports: {} }; e[s][0].call(c.exports, function (t) { var n = e[s][1][t]; return a(n ? n : t) }, c, c.exports, o, e, t, n) } return t[s].exports } for (var r = "function" == typeof require && require, s = 0; s < n.length; s++)a(n[s]); return a }({ 1: [function (o, a, r) { var s = function (e) { return e && e.__esModule ? e : { "default": e } }; Object.defineProperty(r, "__esModule", { value: !0 }); var l, i, u, c, d = o("./modules/handle-dom"), f = o("./modules/utils"), p = o("./modules/handle-swal-dom"), m = o("./modules/handle-click"), v = o("./modules/handle-key"), y = s(v), h = o("./modules/default-params"), b = s(h), g = o("./modules/set-params"), w = s(g); r["default"] = u = c = function () { function o(e) { var t = a; return t[e] === n ? b["default"][e] : t[e] } var a = arguments[0]; if (d.addClass(t.body, "stop-scrolling"), p.resetInput(), a === n) return f.logStr("SweetAlert expects at least 1 attribute!"), !1; var r = f.extend({}, b["default"]); switch (typeof a) { case "string": r.title = a, r.text = arguments[1] || "", r.type = arguments[2] || ""; break; case "object": if (a.title === n) return f.logStr('Missing "title" argument!'), !1; r.title = a.title; for (var s in b["default"]) r[s] = o(s); r.confirmButtonText = r.showCancelButton ? "Confirm" : b["default"].confirmButtonText, r.confirmButtonText = o("confirmButtonText"), r.doneFunction = arguments[1] || null; break; default: return f.logStr('Unexpected type of argument! Expected "string" or "object", got ' + typeof a), !1 }w["default"](r), p.fixVerticalPosition(), p.openModal(arguments[1]); for (var u = p.getModal(), v = u.querySelectorAll("button"), h = ["onclick", "onmouseover", "onmouseout", "onmousedown", "onmouseup", "onfocus"], g = function (e) { return m.handleButton(e, r, u) }, C = 0; C < v.length; C++)for (var S = 0; S < h.length; S++) { var x = h[S]; v[C][x] = g } p.getOverlay().onclick = g, l = e.onkeydown; var k = function (e) { return y["default"](e, r, u) }; e.onkeydown = k, e.onfocus = function () { setTimeout(function () { i !== n && (i.focus(), i = n) }, 0) }, c.enableButtons() }, u.setDefaults = c.setDefaults = function (e) { if (!e) throw new Error("userParams is required"); if ("object" != typeof e) throw new Error("userParams has to be a object"); f.extend(b["default"], e) }, u.close = c.close = function () { var o = p.getModal(); d.fadeOut(p.getOverlay(), 5), d.fadeOut(o, 5), d.removeClass(o, "showSweetAlert"), d.addClass(o, "hideSweetAlert"), d.removeClass(o, "visible"); var a = o.querySelector(".sa-icon.sa-success"); d.removeClass(a, "animate"), d.removeClass(a.querySelector(".sa-tip"), "animateSuccessTip"), d.removeClass(a.querySelector(".sa-long"), "animateSuccessLong"); var r = o.querySelector(".sa-icon.sa-error"); d.removeClass(r, "animateErrorIcon"), d.removeClass(r.querySelector(".sa-x-mark"), "animateXMark"); var s = o.querySelector(".sa-icon.sa-warning"); return d.removeClass(s, "pulseWarning"), d.removeClass(s.querySelector(".sa-body"), "pulseWarningIns"), d.removeClass(s.querySelector(".sa-dot"), "pulseWarningIns"), setTimeout(function () { var e = o.getAttribute("data-custom-class"); d.removeClass(o, e) }, 300), d.removeClass(t.body, "stop-scrolling"), e.onkeydown = l, e.previousActiveElement && e.previousActiveElement.focus(), i = n, clearTimeout(o.timeout), !0 }, u.showInputError = c.showInputError = function (e) { var t = p.getModal(), n = t.querySelector(".sa-input-error"); d.addClass(n, "show"); var o = t.querySelector(".sa-error-container"); d.addClass(o, "show"), o.querySelector("p").innerHTML = e, setTimeout(function () { u.enableButtons() }, 1), t.querySelector("input").focus() }, u.resetInputError = c.resetInputError = function (e) { if (e && 13 === e.keyCode) return !1; var t = p.getModal(), n = t.querySelector(".sa-input-error"); d.removeClass(n, "show"); var o = t.querySelector(".sa-error-container"); d.removeClass(o, "show") }, u.disableButtons = c.disableButtons = function () { var e = p.getModal(), t = e.querySelector("button.confirm"), n = e.querySelector("button.cancel"); t.disabled = !0, n.disabled = !0 }, u.enableButtons = c.enableButtons = function () { var e = p.getModal(), t = e.querySelector("button.confirm"), n = e.querySelector("button.cancel"); t.disabled = !1, n.disabled = !1 }, "undefined" != typeof e ? e.sweetAlert = e.swal = u : f.logStr("SweetAlert is a frontend module!"), a.exports = r["default"] }, { "./modules/default-params": 2, "./modules/handle-click": 3, "./modules/handle-dom": 4, "./modules/handle-key": 5, "./modules/handle-swal-dom": 6, "./modules/set-params": 8, "./modules/utils": 9 }], 2: [function (e, t, n) { Object.defineProperty(n, "__esModule", { value: !0 }); var o = { title: "", text: "", type: null, allowOutsideClick: !1, showConfirmButton: !0, showCancelButton: !1, closeOnConfirm: !0, closeOnCancel: !0, confirmButtonText: "OK", confirmButtonColor: "#8CD4F5", cancelButtonText: "Cancel", imageUrl: null, imageSize: null, timer: null, customClass: "", html: !1, animation: !0, allowEscapeKey: !0, inputType: "text", inputPlaceholder: "", inputValue: "", showLoaderOnConfirm: !1 }; n["default"] = o, t.exports = n["default"] }, {}], 3: [function (t, n, o) { Object.defineProperty(o, "__esModule", { value: !0 }); var a = t("./utils"), r = (t("./handle-swal-dom"), t("./handle-dom")), s = function (t, n, o) { function s(e) { m && n.confirmButtonColor && (p.style.backgroundColor = e) } var u, c, d, f = t || e.event, p = f.target || f.srcElement, m = -1 !== p.className.indexOf("confirm"), v = -1 !== p.className.indexOf("sweet-overlay"), y = r.hasClass(o, "visible"), h = n.doneFunction && "true" === o.getAttribute("data-has-done-function"); switch (m && n.confirmButtonColor && (u = n.confirmButtonColor, c = a.colorLuminance(u, -.04), d = a.colorLuminance(u, -.14)), f.type) { case "mouseover": s(c); break; case "mouseout": s(u); break; case "mousedown": s(d); break; case "mouseup": s(c); break; case "focus": var b = o.querySelector("button.confirm"), g = o.querySelector("button.cancel"); m ? g.style.boxShadow = "none" : b.style.boxShadow = "none"; break; case "click": var w = o === p, C = r.isDescendant(o, p); if (!w && !C && y && !n.allowOutsideClick) break; m && h && y ? l(o, n) : h && y || v ? i(o, n) : r.isDescendant(o, p) && "BUTTON" === p.tagName && sweetAlert.close() } }, l = function (e, t) { var n = !0; r.hasClass(e, "show-input") && (n = e.querySelector("input").value, n || (n = "")), t.doneFunction(n), t.closeOnConfirm && sweetAlert.close(), t.showLoaderOnConfirm && sweetAlert.disableButtons() }, i = function (e, t) { var n = String(t.doneFunction).replace(/\s/g, ""), o = "function(" === n.substring(0, 9) && ")" !== n.substring(9, 10); o && t.doneFunction(!1), t.closeOnCancel && sweetAlert.close() }; o["default"] = { handleButton: s, handleConfirm: l, handleCancel: i }, n.exports = o["default"] }, { "./handle-dom": 4, "./handle-swal-dom": 6, "./utils": 9 }], 4: [function (n, o, a) { Object.defineProperty(a, "__esModule", { value: !0 }); var r = function (e, t) { return new RegExp(" " + t + " ").test(" " + e.className + " ") }, s = function (e, t) { r(e, t) || (e.className += " " + t) }, l = function (e, t) { var n = " " + e.className.replace(/[\t\r\n]/g, " ") + " "; if (r(e, t)) { for (; n.indexOf(" " + t + " ") >= 0;)n = n.replace(" " + t + " ", " "); e.className = n.replace(/^\s+|\s+$/g, "") } }, i = function (e) { var n = t.createElement("div"); return n.appendChild(t.createTextNode(e)), n.innerHTML }, u = function (e) { e.style.opacity = "", e.style.display = "block" }, c = function (e) { if (e && !e.length) return u(e); for (var t = 0; t < e.length; ++t)u(e[t]) }, d = function (e) { e.style.opacity = "", e.style.display = "none" }, f = function (e) { if (e && !e.length) return d(e); for (var t = 0; t < e.length; ++t)d(e[t]) }, p = function (e, t) { for (var n = t.parentNode; null !== n;) { if (n === e) return !0; n = n.parentNode } return !1 }, m = function (e) { e.style.left = "-9999px", e.style.display = "block"; var t, n = e.clientHeight; return t = "undefined" != typeof getComputedStyle ? parseInt(getComputedStyle(e).getPropertyValue("padding-top"), 10) : parseInt(e.currentStyle.padding), e.style.left = "", e.style.display = "none", "-" + parseInt((n + t) / 2) + "px" }, v = function (e, t) { if (+e.style.opacity < 1) { t = t || 16, e.style.opacity = 0, e.style.display = "block"; var n = +new Date, o = function (e) { function t() { return e.apply(this, arguments) } return t.toString = function () { return e.toString() }, t }(function () { e.style.opacity = +e.style.opacity + (new Date - n) / 100, n = +new Date, +e.style.opacity < 1 && setTimeout(o, t) }); o() } e.style.display = "block" }, y = function (e, t) { t = t || 16, e.style.opacity = 1; var n = +new Date, o = function (e) { function t() { return e.apply(this, arguments) } return t.toString = function () { return e.toString() }, t }(function () { e.style.opacity = +e.style.opacity - (new Date - n) / 100, n = +new Date, +e.style.opacity > 0 ? setTimeout(o, t) : e.style.display = "none" }); o() }, h = function (n) { if ("function" == typeof MouseEvent) { var o = new MouseEvent("click", { view: e, bubbles: !1, cancelable: !0 }); n.dispatchEvent(o) } else if (t.createEvent) { var a = t.createEvent("MouseEvents"); a.initEvent("click", !1, !1), n.dispatchEvent(a) } else t.createEventObject ? n.fireEvent("onclick") : "function" == typeof n.onclick && n.onclick() }, b = function (t) { "function" == typeof t.stopPropagation ? (t.stopPropagation(), t.preventDefault()) : e.event && e.event.hasOwnProperty("cancelBubble") && (e.event.cancelBubble = !0) }; a.hasClass = r, a.addClass = s, a.removeClass = l, a.escapeHtml = i, a._show = u, a.show = c, a._hide = d, a.hide = f, a.isDescendant = p, a.getTopMargin = m, a.fadeIn = v, a.fadeOut = y, a.fireClick = h, a.stopEventPropagation = b }, {}], 5: [function (t, o, a) { Object.defineProperty(a, "__esModule", { value: !0 }); var r = t("./handle-dom"), s = t("./handle-swal-dom"), l = function (t, o, a) { var l = t || e.event, i = l.keyCode || l.which, u = a.querySelector("button.confirm"), c = a.querySelector("button.cancel"), d = a.querySelectorAll("button[tabindex]"); if (-1 !== [9, 13, 32, 27].indexOf(i)) { for (var f = l.target || l.srcElement, p = -1, m = 0; m < d.length; m++)if (f === d[m]) { p = m; break } 9 === i ? (f = -1 === p ? u : p === d.length - 1 ? d[0] : d[p + 1], r.stopEventPropagation(l), f.focus(), o.confirmButtonColor && s.setFocusStyle(f, o.confirmButtonColor)) : 13 === i ? ("INPUT" === f.tagName && (f = u, u.focus()), f = -1 === p ? u : n) : 27 === i && o.allowEscapeKey === !0 ? (f = c, r.fireClick(f, l)) : f = n } }; a["default"] = l, o.exports = a["default"] }, { "./handle-dom": 4, "./handle-swal-dom": 6 }], 6: [function (n, o, a) { var r = function (e) { return e && e.__esModule ? e : { "default": e } }; Object.defineProperty(a, "__esModule", { value: !0 }); var s = n("./utils"), l = n("./handle-dom"), i = n("./default-params"), u = r(i), c = n("./injected-html"), d = r(c), f = ".sweet-alert", p = ".sweet-overlay", m = function () { var e = t.createElement("div"); for (e.innerHTML = d["default"]; e.firstChild;)t.body.appendChild(e.firstChild) }, v = function (e) { function t() { return e.apply(this, arguments) } return t.toString = function () { return e.toString() }, t }(function () { var e = t.querySelector(f); return e || (m(), e = v()), e }), y = function () { var e = v(); return e ? e.querySelector("input") : void 0 }, h = function () { return t.querySelector(p) }, b = function (e, t) { var n = s.hexToRgb(t); e.style.boxShadow = "0 0 2px rgba(" + n + ", 0.8), inset 0 0 0 1px rgba(0, 0, 0, 0.05)" }, g = function (n) { var o = v(); l.fadeIn(h(), 10), l.show(o), l.addClass(o, "showSweetAlert"), l.removeClass(o, "hideSweetAlert"), e.previousActiveElement = t.activeElement; var a = o.querySelector("button.confirm"); a.focus(), setTimeout(function () { l.addClass(o, "visible") }, 500); var r = o.getAttribute("data-timer"); if ("null" !== r && "" !== r) { var s = n; o.timeout = setTimeout(function () { var e = (s || null) && "true" === o.getAttribute("data-has-done-function"); e ? s(null) : sweetAlert.close() }, r) } }, w = function () { var e = v(), t = y(); l.removeClass(e, "show-input"), t.value = u["default"].inputValue, t.setAttribute("type", u["default"].inputType), t.setAttribute("placeholder", u["default"].inputPlaceholder), C() }, C = function (e) { if (e && 13 === e.keyCode) return !1; var t = v(), n = t.querySelector(".sa-input-error"); l.removeClass(n, "show"); var o = t.querySelector(".sa-error-container"); l.removeClass(o, "show") }, S = function () { var e = v(); e.style.marginTop = l.getTopMargin(v()) }; a.sweetAlertInitialize = m, a.getModal = v, a.getOverlay = h, a.getInput = y, a.setFocusStyle = b, a.openModal = g, a.resetInput = w, a.resetInputError = C, a.fixVerticalPosition = S }, { "./default-params": 2, "./handle-dom": 4, "./injected-html": 7, "./utils": 9 }], 7: [function (e, t, n) { Object.defineProperty(n, "__esModule", { value: !0 }); var o = '<div class="sweet-overlay" tabIndex="-1"></div><div class="sweet-alert"><div class="sa-icon sa-error">\n      <span class="sa-x-mark">\n        <span class="sa-line sa-left"></span>\n        <span class="sa-line sa-right"></span>\n      </span>\n    </div><div class="sa-icon sa-warning">\n      <span class="sa-body"></span>\n      <span class="sa-dot"></span>\n    </div><div class="sa-icon sa-info"></div><div class="sa-icon sa-success">\n      <span class="sa-line sa-tip"></span>\n      <span class="sa-line sa-long"></span>\n\n      <div class="sa-placeholder"></div>\n      <div class="sa-fix"></div>\n    </div><div class="sa-icon sa-custom"></div><h2>Title</h2>\n    <p>Text</p>\n    <fieldset>\n      <input type="text" tabIndex="3" />\n      <div class="sa-input-error"></div>\n    </fieldset><div class="sa-error-container">\n      <div class="icon">!</div>\n      <p>Not valid!</p>\n    </div><div class="sa-button-container">\n      <button class="cancel" tabIndex="2">Cancel</button>\n      <div class="sa-confirm-button-container">\n        <button class="confirm" tabIndex="1">OK</button><div class="la-ball-fall">\n          <div></div>\n          <div></div>\n          <div></div>\n        </div>\n      </div>\n    </div></div>'; n["default"] = o, t.exports = n["default"] }, {}], 8: [function (e, t, o) { Object.defineProperty(o, "__esModule", { value: !0 }); var a = e("./utils"), r = e("./handle-swal-dom"), s = e("./handle-dom"), l = ["error", "warning", "info", "success", "input", "prompt"], i = function (e) { var t = r.getModal(), o = t.querySelector("h2"), i = t.querySelector("p"), u = t.querySelector("button.cancel"), c = t.querySelector("button.confirm"); if (o.innerHTML = e.html ? e.title : s.escapeHtml(e.title).split("\n").join("<br>"), i.innerHTML = e.html ? e.text : s.escapeHtml(e.text || "").split("\n").join("<br>"), e.text && s.show(i), e.customClass) s.addClass(t, e.customClass), t.setAttribute("data-custom-class", e.customClass); else { var d = t.getAttribute("data-custom-class"); s.removeClass(t, d), t.setAttribute("data-custom-class", "") } if (s.hide(t.querySelectorAll(".sa-icon")), e.type && !a.isIE8()) { var f = function () { for (var o = !1, a = 0; a < l.length; a++)if (e.type === l[a]) { o = !0; break } if (!o) return logStr("Unknown alert type: " + e.type), { v: !1 }; var i = ["success", "error", "warning", "info"], u = n; -1 !== i.indexOf(e.type) && (u = t.querySelector(".sa-icon.sa-" + e.type), s.show(u)); var c = r.getInput(); switch (e.type) { case "success": s.addClass(u, "animate"), s.addClass(u.querySelector(".sa-tip"), "animateSuccessTip"), s.addClass(u.querySelector(".sa-long"), "animateSuccessLong"); break; case "error": s.addClass(u, "animateErrorIcon"), s.addClass(u.querySelector(".sa-x-mark"), "animateXMark"); break; case "warning": s.addClass(u, "pulseWarning"), s.addClass(u.querySelector(".sa-body"), "pulseWarningIns"), s.addClass(u.querySelector(".sa-dot"), "pulseWarningIns"); break; case "input": case "prompt": c.setAttribute("type", e.inputType), c.value = e.inputValue, c.setAttribute("placeholder", e.inputPlaceholder), s.addClass(t, "show-input"), setTimeout(function () { c.focus(), c.addEventListener("keyup", swal.resetInputError) }, 400) } }(); if ("object" == typeof f) return f.v } if (e.imageUrl) { var p = t.querySelector(".sa-icon.sa-custom"); p.style.backgroundImage = "url(" + e.imageUrl + ")", s.show(p); var m = 80, v = 80; if (e.imageSize) { var y = e.imageSize.toString().split("x"), h = y[0], b = y[1]; h && b ? (m = h, v = b) : logStr("Parameter imageSize expects value with format WIDTHxHEIGHT, got " + e.imageSize) } p.setAttribute("style", p.getAttribute("style") + "width:" + m + "px; height:" + v + "px") } t.setAttribute("data-has-cancel-button", e.showCancelButton), e.showCancelButton ? u.style.display = "inline-block" : s.hide(u), t.setAttribute("data-has-confirm-button", e.showConfirmButton), e.showConfirmButton ? c.style.display = "inline-block" : s.hide(c), e.cancelButtonText && (u.innerHTML = s.escapeHtml(e.cancelButtonText)), e.confirmButtonText && (c.innerHTML = s.escapeHtml(e.confirmButtonText)), e.confirmButtonColor && (c.style.backgroundColor = e.confirmButtonColor, c.style.borderLeftColor = e.confirmLoadingButtonColor, c.style.borderRightColor = e.confirmLoadingButtonColor, r.setFocusStyle(c, e.confirmButtonColor)), t.setAttribute("data-allow-outside-click", e.allowOutsideClick); var g = e.doneFunction ? !0 : !1; t.setAttribute("data-has-done-function", g), e.animation ? "string" == typeof e.animation ? t.setAttribute("data-animation", e.animation) : t.setAttribute("data-animation", "pop") : t.setAttribute("data-animation", "none"), t.setAttribute("data-timer", e.timer) }; o["default"] = i, t.exports = o["default"] }, { "./handle-dom": 4, "./handle-swal-dom": 6, "./utils": 9 }], 9: [function (t, n, o) { Object.defineProperty(o, "__esModule", { value: !0 }); var a = function (e, t) { for (var n in t) t.hasOwnProperty(n) && (e[n] = t[n]); return e }, r = function (e) { var t = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(e); return t ? parseInt(t[1], 16) + ", " + parseInt(t[2], 16) + ", " + parseInt(t[3], 16) : null }, s = function () { return e.attachEvent && !e.addEventListener }, l = function (t) { e.console && e.console.log("SweetAlert: " + t) }, i = function (e, t) { e = String(e).replace(/[^0-9a-f]/gi, ""), e.length < 6 && (e = e[0] + e[0] + e[1] + e[1] + e[2] + e[2]), t = t || 0; var n, o, a = "#"; for (o = 0; 3 > o; o++)n = parseInt(e.substr(2 * o, 2), 16), n = Math.round(Math.min(Math.max(0, n + n * t), 255)).toString(16), a += ("00" + n).substr(n.length); return a }; o.extend = a, o.hexToRgb = r, o.isIE8 = s, o.logStr = l, o.colorLuminance = i }, {}] }, {}, [1]), "function" == typeof define && define.amd ? define(function () { return sweetAlert }) : "undefined" != typeof module && module.exports && (module.exports = sweetAlert) }(window, document);
// SweetAlert end
// Additional code
var _hmt = _hmt || [];
(function () {
	// 评论框
	domready(function () {
		showAnnouncement();
		loadcomment();
	});
	// 统计
	var hm = document.createElement("script");
	hm.src = "//hm.baidu.com/hm.js?b5403b0006ff36b96e269c5bad28d40e";
	var s = document.getElementsByTagName("script")[0];
	s.parentNode.insertBefore(hm, s);
})();
