
Liferay.Loader.define(
	'mbop-sample-module-js-web@0.0.0/mbop-sample-module-js-web/runtime',
	['module'],
	function(module) {
		module.exports = function(_LIFERAY_PARAMS_, _ADAPT_RT_) {
			(()=>{"use strict";var e,r={},o={};function t(e){var n=o[e];if(void 0!==n)return n.exports;var a=o[e]={exports:{}};return r[e](a,a.exports,t),a.exports}t.m=r,e=[],t.O=(r,o,n,a)=>{if(!o){var l=1/0;for(u=0;u<e.length;u++){for(var[o,n,a]=e[u],s=!0,p=0;p<o.length;p++)(!1&a||l>=a)&&Object.keys(t.O).every(e=>t.O[e](o[p]))?o.splice(p--,1):(s=!1,a<l&&(l=a));s&&(e.splice(u--,1),r=n())}return r}a=a||0;for(var u=e.length;u>0&&e[u-1][2]>a;u--)e[u]=e[u-1];e[u]=[o,n,a]},t.n=e=>{var r=e&&e.__esModule?()=>e.default:()=>e;return t.d(r,{a:r}),r},t.d=(e,r)=>{for(var o in r)t.o(r,o)&&!t.o(e,o)&&Object.defineProperty(e,o,{enumerable:!0,get:r[o]})},t.o=(e,r)=>Object.prototype.hasOwnProperty.call(e,r),(()=>{var e={666:0};t.O.j=r=>0===e[r];var r=(r,o)=>{var n,a,[l,s,p]=o,u=0;for(n in s)t.o(s,n)&&(t.m[n]=s[n]);if(p)var f=p(t);for(r&&r(o);u<l.length;u++)t.o(e,a=l[u])&&e[a]&&e[a][0](),e[l[u]]=0;return t.O(f)},o=self.webpackChunkmbop_sample_module_js_web=self.webpackChunkmbop_sample_module_js_web||[];o.forEach(r.bind(null,0)),o.push=r.bind(null,o.push.bind(o))})()})();
		}
	}
);