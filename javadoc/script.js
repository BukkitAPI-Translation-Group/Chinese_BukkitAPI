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
function loadcomment() {
	// 过渡至新评论系统
	// 2017年5月5日后自动切换
	var date = new Date();
	date.setFullYear(2017, 4, 5);
	if (date > new Date()) {
		loadduoshuo();
	} else {
		var contentContainers = document.getElementsByClassName("contentContainer");
		if (contentContainers.length > 0) {
			var lastContentContainer = contentContainers[contentContainers.length - 1];
			var div = document.createElement("div");
			div.setAttribute("id", "lv-container");
			div.setAttribute("data-id", "city");
			div.setAttribute("data-uid", "MTAyMC8yODIzNC80ODA2");
			lastContentContainer.appendChild(div);
			var script = document.createElement("script");
			script.innerHTML = "(function(d, s) {\
       var j, e = d.getElementsByTagName(s)[0];\
       if (typeof LivereTower === 'function') { return; }\
       j = d.createElement(s);\
       j.src = \"https://cdn-city.livere.com/js/embed.dist.js\";\
       j.async = true;\
       e.parentNode.insertBefore(j, e);\
   })(document, 'script');";
			lastContentContainer.appendChild(script);
		}
	}
}
function loadduoshuo() {
	var appendToFooter = document.createElement("script");
	appendToFooter.innerHTML = 'var contentContainers = document.getElementsByClassName("contentContainer");\
		if (contentContainers.length > 0) {\
			var lastContentContainer = contentContainers[contentContainers.length - 1];\
			var div = document.createElement("div");\
			div.setAttribute("class", "ds-thread");\
			div.setAttribute("data-title", document.title);\
			div.setAttribute("data-url", "");\
			var loc = window.location;\
			if (loc.pathname.includes("org")) {\
				div.setAttribute("data-thread-key", loc.pathname.slice(window.location.pathname.indexOf("org")));\
			} else {\
				div.setAttribute("data-thread-key", window.location.pathname.slice(window.location.pathname.lastIndexOf("/") + 1));\
			}\
			lastContentContainer.appendChild(div);\
			var script = document.createElement("script");\
			script.innerHTML = \'var duoshuoQuery = {short_name:\"bukkitcomm\"};(function() {var ds = document.createElement("script");ds.type = "text/javascript";ds.async = true;ds.charset = "UTF-8";(document.getElementsByTagName("head")[0]  || document.getElementsByTagName("body")[0]).appendChild(ds);})();\';\
			lastContentContainer.appendChild(script);\
			$script("https://dn-hb0716.qbox.me/duoshuo.js", function () {\
			DUOSHUO.EmbedThread(".ds-thread");\
			DUOSHUO.ThreadCount(".ds-thread-count");\
			});\
		}';
	document.getElementsByTagName("body")[0].appendChild(appendToFooter);
}
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
// Additional code
var _hmt = _hmt || [];
(function () {
	// InstantClick
	$script.get('https://cdn.staticfile.org/instantclick/3.0.1/instantclick.min.js', function () {
		InstantClick.on('change', function (isInitialLoad) {
			if (isInitialLoad === false) {
				if (typeof _hmt !== 'undefined') _hmt.push(['_trackPageview', location.pathname + location.search]);
				if (typeof DUOSHUO != 'undefined' || typeof LivereTower != 'undefined') {
					loadcomment();
				}
			}
		});
		InstantClick.init();
	});
	// 评论框
	domready(loadcomment);
	// 统计
	var hm = document.createElement("script");
	hm.src = "//hm.baidu.com/hm.js?b5403b0006ff36b96e269c5bad28d40e";
	var s = document.getElementsByTagName("script")[0];
	s.parentNode.insertBefore(hm, s);
})();
