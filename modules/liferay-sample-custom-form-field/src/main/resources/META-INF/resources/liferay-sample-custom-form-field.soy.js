/* jshint ignore:start */
import Component from 'metal-component';
import Soy from 'metal-soy';

var templates;
goog.loadModule(function(exports) {
var soy = goog.require('soy');
var soydata = goog.require('soydata');
// This file was automatically generated from liferay-sample-custom-form-field.soy.
// Please don't edit this file by hand.

/**
 * @fileoverview Templates in namespace Sample.
 * @public
 */

goog.module('Sample.incrementaldom');

goog.require('goog.soy.data.SanitizedContent');
var incrementalDom = goog.require('incrementaldom');
goog.require('soy.asserts');
var soyIdom = goog.require('soy.idom');

var $templateAlias1 = Soy.getTemplate('FieldBase.incrementaldom', 'render');


/**
 * @param {{
 *  label: (!goog.soy.data.SanitizedContent|string),
 *  name: (!goog.soy.data.SanitizedContent|string),
 *  showLabel: boolean,
 *  tip: (!goog.soy.data.SanitizedContent|string),
 *  value: (?),
 *  _handleFieldChanged: (*|null|undefined),
 *  predefinedValue: (*|null|undefined),
 *  required: (boolean|null|undefined),
 *  spritemap: (!goog.soy.data.SanitizedContent|null|string|undefined)
 * }} opt_data
 * @param {Object<string, *>=} opt_ijData
 * @param {Object<string, *>=} opt_ijData_deprecated
 * @return {void}
 * @suppress {checkTypes}
 */
function $render(opt_data, opt_ijData, opt_ijData_deprecated) {
  opt_ijData = opt_ijData_deprecated || opt_ijData;
  /** @type {!goog.soy.data.SanitizedContent|string} */
  var label = soy.asserts.assertType(goog.isString(opt_data.label) || opt_data.label instanceof goog.soy.data.SanitizedContent, 'label', opt_data.label, '!goog.soy.data.SanitizedContent|string');
  /** @type {!goog.soy.data.SanitizedContent|string} */
  var name = soy.asserts.assertType(goog.isString(opt_data.name) || opt_data.name instanceof goog.soy.data.SanitizedContent, 'name', opt_data.name, '!goog.soy.data.SanitizedContent|string');
  /** @type {boolean} */
  var showLabel = soy.asserts.assertType(goog.isBoolean(opt_data.showLabel) || opt_data.showLabel === 1 || opt_data.showLabel === 0, 'showLabel', opt_data.showLabel, 'boolean');
  /** @type {!goog.soy.data.SanitizedContent|string} */
  var tip = soy.asserts.assertType(goog.isString(opt_data.tip) || opt_data.tip instanceof goog.soy.data.SanitizedContent, 'tip', opt_data.tip, '!goog.soy.data.SanitizedContent|string');
  /** @type {?} */
  var value = opt_data.value;
  /** @type {*|null|undefined} */
  var _handleFieldChanged = opt_data._handleFieldChanged;
  /** @type {*|null|undefined} */
  var predefinedValue = opt_data.predefinedValue;
  /** @type {boolean|null|undefined} */
  var required = soy.asserts.assertType(opt_data.required == null || (goog.isBoolean(opt_data.required) || opt_data.required === 1 || opt_data.required === 0), 'required', opt_data.required, 'boolean|null|undefined');
  /** @type {!goog.soy.data.SanitizedContent|null|string|undefined} */
  var spritemap = soy.asserts.assertType(opt_data.spritemap == null || (goog.isString(opt_data.spritemap) || opt_data.spritemap instanceof goog.soy.data.SanitizedContent), 'spritemap', opt_data.spritemap, '!goog.soy.data.SanitizedContent|null|string|undefined');
  var param14 = function() {
    $content(opt_data, null, opt_ijData);
  };
  $templateAlias1({contentRenderer: param14, label: label, name: name, required: required, showLabel: showLabel, spritemap: spritemap, tip: tip}, null, opt_ijData);
}
exports.render = $render;
/**
 * @typedef {{
 *  label: (!goog.soy.data.SanitizedContent|string),
 *  name: (!goog.soy.data.SanitizedContent|string),
 *  showLabel: boolean,
 *  tip: (!goog.soy.data.SanitizedContent|string),
 *  value: (?),
 *  _handleFieldChanged: (*|null|undefined),
 *  predefinedValue: (*|null|undefined),
 *  required: (boolean|null|undefined),
 *  spritemap: (!goog.soy.data.SanitizedContent|null|string|undefined)
 * }}
 */
$render.Params;
if (goog.DEBUG) {
  $render.soyTemplateName = 'Sample.render';
}


/**
 * @param {{
 *  name: (!goog.soy.data.SanitizedContent|string),
 *  value: (?),
 *  _handleFieldChanged: (*|null|undefined),
 *  predefinedValue: (*|null|undefined)
 * }} opt_data
 * @param {Object<string, *>=} opt_ijData
 * @param {Object<string, *>=} opt_ijData_deprecated
 * @return {void}
 * @suppress {checkTypes}
 */
function $content(opt_data, opt_ijData, opt_ijData_deprecated) {
  opt_ijData = opt_ijData_deprecated || opt_ijData;
  /** @type {!goog.soy.data.SanitizedContent|string} */
  var name = soy.asserts.assertType(goog.isString(opt_data.name) || opt_data.name instanceof goog.soy.data.SanitizedContent, 'name', opt_data.name, '!goog.soy.data.SanitizedContent|string');
  /** @type {?} */
  var value = opt_data.value;
  /** @type {*|null|undefined} */
  var _handleFieldChanged = opt_data._handleFieldChanged;
  /** @type {*|null|undefined} */
  var predefinedValue = opt_data.predefinedValue;
  var attributes__soy35 = function() {
    incrementalDom.attr('class', 'ddm-field-liferay-sample-custom-form-field form-control liferay-sample-custom-form-field');
    incrementalDom.attr('data-oninput', _handleFieldChanged);
    incrementalDom.attr('name', name);
    incrementalDom.attr('type', 'text');
    if (value) {
      incrementalDom.attr('value', value);
    } else {
      incrementalDom.attr('value', predefinedValue);
    }
  };
  incrementalDom.elementOpenStart('input');
      attributes__soy35();
  incrementalDom.elementOpenEnd();
  incrementalDom.elementClose('input');
}
exports.content = $content;
/**
 * @typedef {{
 *  name: (!goog.soy.data.SanitizedContent|string),
 *  value: (?),
 *  _handleFieldChanged: (*|null|undefined),
 *  predefinedValue: (*|null|undefined)
 * }}
 */
$content.Params;
if (goog.DEBUG) {
  $content.soyTemplateName = 'Sample.content';
}

exports.render.params = ["label","name","showLabel","tip","value","_handleFieldChanged","predefinedValue","required","spritemap"];
exports.render.types = {"label":"string","name":"string","showLabel":"bool","tip":"string","value":"?","_handleFieldChanged":"any","predefinedValue":"any","required":"bool","spritemap":"string"};
exports.content.params = ["name","value","_handleFieldChanged","predefinedValue"];
exports.content.types = {"name":"string","value":"?","_handleFieldChanged":"any","predefinedValue":"any"};
templates = exports;
return exports;

});

class Sample extends Component {}
Soy.register(Sample, templates);
export { Sample, templates };
export default templates;
/* jshint ignore:end */
