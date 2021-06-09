
Liferay.Loader.define(
	'liferay-sample-module-js-web@0.0.0/liferay-sample-module-js-web/runtime',
	['module'],
	function(module) {
		module.exports = function(_LIFERAY_PARAMS_, _ADAPT_RT_) {
			(()=>{"use strict";var e,r={},o={};function t(e){var a=o[e];if(void 0!==a)return a.exports;var n=o[e]={exports:{}};return r[e](n,n.exports,t),n.exports}t.m=r,e=[],t.O=(r,o,a,n)=>{if(!o){var l=1/0;for(f=0;f<e.length;f++){for(var[o,a,n]=e[f],s=!0,u=0;u<o.length;u++)(!1&n||l>=n)&&Object.keys(t.O).every(e=>t.O[e](o[u]))?o.splice(u--,1):(s=!1,n<l&&(l=n));s&&(e.splice(f--,1),r=a())}return r}n=n||0;for(var f=e.length;f>0&&e[f-1][2]>n;f--)e[f]=e[f-1];e[f]=[o,a,n]},t.n=e=>{var r=e&&e.__esModule?()=>e.default:()=>e;return t.d(r,{a:r}),r},t.d=(e,r)=>{for(var o in r)t.o(r,o)&&!t.o(e,o)&&Object.defineProperty(e,o,{enumerable:!0,get:r[o]})},t.o=(e,r)=>Object.prototype.hasOwnProperty.call(e,r),(()=>{var e={666:0};t.O.j=r=>0===e[r];var r=(r,o)=>{var a,n,[l,s,u]=o,f=0;for(a in s)t.o(s,a)&&(t.m[a]=s[a]);if(u)var i=u(t);for(r&&r(o);f<l.length;f++)t.o(e,n=l[f])&&e[n]&&e[n][0](),e[l[f]]=0;return t.O(i)},o=self.webpackChunkliferay_sample_module_js_web=self.webpackChunkliferay_sample_module_js_web||[];o.forEach(r.bind(null,0)),o.push=r.bind(null,o.push.bind(o))})()})();
		}
	}
);