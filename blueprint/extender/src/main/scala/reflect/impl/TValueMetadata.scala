package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.ValueMetadata

trait TValueMetadata  extends ValueMetadata with TNonNullMetadata

class ValueMetadataImpl ( stringValue:String,
	 tipe:String) extends TValueMetadata