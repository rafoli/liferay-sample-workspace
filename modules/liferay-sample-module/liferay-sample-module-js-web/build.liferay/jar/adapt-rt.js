Liferay.Loader.define("liferay-sample-module-js-web@0.0.0/adapt-rt", ['module', 'exports', 'require'], function (module, exports, require) {
	var define = undefined;
	var global = window;
	{
		var PATH_CONTEXT = Liferay.ThemeDisplay.getPathContext();

		function adaptStaticURL(url) {
			return PATH_CONTEXT + "/o/liferay-sample-module-js-web-0.0.0/liferay-sample-module-js-web/" + url;
		}

		module.exports = {
			adaptStaticURL: adaptStaticURL
		};
	}
});