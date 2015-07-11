package com.ardublock.translator.block.monoxit;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
//import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
	
public class Mi100ReverseSpin extends TranslatorBlock
{

	public Mi100ReverseSpin(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
				
		TranslatorBlock tbDurationBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String duration = tbDurationBlock.toCode();
		
		if (Integer.parseInt(duration) > 1000 ) 
		{
			//throw new BlockException(this.blockId, "the duration must not be over 1000");
			//duration = "1000";
		}
		
    String instanceName = "ROBO";
    
    String ret = "\t" + instanceName + ".reverseSpin(" + duration + ");\n";
    
		translator.addHeaderFile("MI100lib.h");
		translator.addDefinitionCommand("MI100 " + instanceName + ";");
		//translator.addSetupCommand(instanceName + ".setDefaultSpeed(" + speed + ");");

		return ret;
		}

	}
