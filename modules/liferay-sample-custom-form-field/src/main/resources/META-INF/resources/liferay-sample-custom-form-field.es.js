import 'dynamic-data-mapping-form-field-type/FieldBase/FieldBase.es';
import './liferay-sample-custom-form-fieldRegister.soy.js';
import templates from './liferay-sample-custom-form-field.soy.js';
import {Config} from 'metal-state';

import Component from 'metal-component';
import Soy from 'metal-soy';

/**
 * Sample Component
 */
class Sample extends Component {

	dispatchEvent(event, name, value) {
		this.emit(name, {
			fieldInstance: this,
			originalEvent: event,
			value
		});
	}

	_handleFieldChanged(event) {
		const {value} = event.target;

		this.setState(
			{
				value
			},
			() => this.dispatchEvent(event, 'fieldEdited', value)
		);
	}
}

Sample.STATE = {

	name: Config.string().required(),

	predefinedValue: Config.oneOfType([Config.number(), Config.string()]),

	required: Config.bool().value(false),

	showLabel: Config.bool().value(true),

	spritemap: Config.string(),

	value: Config.string().value('')
}

// Register component
Soy.register(Sample, templates);

export default Sample;
